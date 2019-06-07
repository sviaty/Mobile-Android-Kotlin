package com.example.spkc6448.keystore

import android.annotation.TargetApi
import android.os.Build
import android.security.keystore.KeyGenParameterSpec
import android.security.keystore.KeyProperties
import android.util.Base64
import android.util.Log
import java.nio.charset.Charset
import java.security.*
import javax.crypto.Cipher
import javax.crypto.KeyGenerator
import javax.crypto.spec.IvParameterSpec

object KeyStoreManager {

    private val CHARSET = "UTF-8"
    private val KEY_ALIAS = "com.orangepro.key"
    private val ANDROID_KEY_STORE = "AndroidKeyStore"

    private lateinit var writer: Cipher
    private lateinit var reader: Cipher

    // Variables pour api >= 23
    private lateinit var secretKey: Key
    private val CBC_MODE = "AES/CBC/PKCS7Padding"
    private val DELIMITER = "]"
    private val KEY_LENGTH = 16

    // Variables pour api < 23
    const val CRYPTO_METHOD = "RSA"
    const val CRYPTO_BITS = 2048
    const val CRYPTO_TRANSFORM = "RSA/ECB/OAEPWithSHA1AndMGF1Padding"
    var privateKey: PrivateKey? = null  // Clé privée pour déchiffrer si api < 23
    var publicKey: PublicKey? = null    // Clé public pour chiffrer si api < 23


    // Initialisation de(s) clé(s) et des cipher
    private fun initSecurity() {

        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                secretKey = getSecretKey()
                writer = Cipher.getInstance(CBC_MODE)
                reader = Cipher.getInstance(CBC_MODE)
            } else {
                val keys = genPublicPrivateKey() ?: return
                publicKey = keys.first
                privateKey = keys.second
                writer = Cipher.getInstance(CRYPTO_TRANSFORM)
                reader = Cipher.getInstance(CRYPTO_TRANSFORM)
            }
        } catch (e: Exception) {
            Log.e("", "")
        }
    }

    // Génération de la clé (symétrique) pour api >= 23
    @TargetApi(Build.VERSION_CODES.M)
    private fun getSecretKey(): Key {

        val keyStore = KeyStore.getInstance(ANDROID_KEY_STORE).apply {
            load(null)
        }

        if (!keyStore.containsAlias(KEY_ALIAS)) {
            val keyGenerator = KeyGenerator.getInstance(KeyProperties.KEY_ALGORITHM_AES, ANDROID_KEY_STORE)
            val builder = KeyGenParameterSpec.Builder(
                KEY_ALIAS,
                KeyProperties.PURPOSE_ENCRYPT or KeyProperties.PURPOSE_DECRYPT
            )
                .setBlockModes(KeyProperties.BLOCK_MODE_CBC)
                .setRandomizedEncryptionRequired(false)
                .setEncryptionPaddings(KeyProperties.ENCRYPTION_PADDING_PKCS7)

            keyGenerator.init(builder.build())
            keyGenerator.generateKey()
        }

        return keyStore.getKey(KEY_ALIAS, null)
    }

    // Génération des clés public et privée (assymétrique) pour api < 23
    private fun genPublicPrivateKey(): Pair<PublicKey, PrivateKey>? {

        val keyPairGenerator = KeyPairGenerator.getInstance(CRYPTO_METHOD)
        keyPairGenerator.initialize(CRYPTO_BITS)
        val kp = keyPairGenerator.genKeyPair()
        return if(kp.private != null && kp.public != null) {
            Pair(kp.public, kp.private)
        } else {
            null
        }

    }

    private  fun encrypt(value: String): String? {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            return try {
                val iv = getIv()
                writer.init(Cipher.ENCRYPT_MODE, secretKey, IvParameterSpec(iv))
                val secureValue = writer.doFinal(value.toByteArray(charset(CHARSET)))
                return Base64.encodeToString(iv, Base64.NO_WRAP) + DELIMITER + Base64.encodeToString(
                    secureValue,
                    Base64.NO_WRAP
                )
            } catch (e: Exception) {
                null
            }
        } else {
            writer.init(Cipher.ENCRYPT_MODE, publicKey)
            val encryptedBytes = writer.doFinal(value.toByteArray(charset(CHARSET)))
            return Base64.encodeToString(encryptedBytes, Base64.DEFAULT)
        }
    }

    private fun decrypt(securedEncodedValue: String): String? {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            return try {
                val secureTab = securedEncodedValue.split(DELIMITER)
                if (secureTab.size < 2) {
                    null
                } else {
                    val iv = Base64.decode(secureTab[0], Base64.NO_WRAP)
                    val securedValue = Base64.decode(secureTab[1], Base64.NO_WRAP)
                    reader.init(Cipher.DECRYPT_MODE, secretKey, IvParameterSpec(iv))

                    val value = reader.doFinal(securedValue)
                    if (value != null) String(value, Charset.forName(CHARSET)) else null
                }
            } catch (e: Exception) {
                null
            }
        } else {
            reader.init(Cipher.DECRYPT_MODE, privateKey)
            val decryptedBytes = reader.doFinal(Base64.decode(securedEncodedValue, Base64.DEFAULT))
            return String(decryptedBytes)
        }
    }

    private fun getIv(): ByteArray {
        val key = ByteArray(KEY_LENGTH)
        SecureRandom().nextBytes(key)
        return key
    }

    fun savePassword(password: String) {

        val pwdEncrypted = encrypt(password)
        // Puis stocker dans les SherdPreferences
    }

    fun retrievePassword() {

        // Récupérer le mot de passe dans les SherdPreferences
        val pwdSharedPreferences = encrypt("Le mot de passe") ?: return
        val pwdDecrypted = decrypt(pwdSharedPreferences)
    }


    fun leSuperTest() {
        initSecurity()

        val leMotDePasseEnClair = "Un super mot de passe"

        val leMotDePasseChiffreAStockerDansLesSharedPreferences = encrypt(leMotDePasseEnClair) ?: return
        Log.e("MyApp", "leMotDePasseChiffré: $leMotDePasseChiffreAStockerDansLesSharedPreferences")

        val leMotDePasseChiffreDechiffre = decrypt(leMotDePasseChiffreAStockerDansLesSharedPreferences)
        Log.e("MyApp", "leMotDePasseChiffreDechiffre: $leMotDePasseChiffreDechiffre")

        if (leMotDePasseEnClair == leMotDePasseChiffreDechiffre) {
            Log.e("MyApp", "ça marche!! :D")
        } else {
            Log.e("MyApp", "ça marche pas!! :(")
        }
    }
}