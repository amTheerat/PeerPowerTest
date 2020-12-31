package th.test.core.extension

import android.util.Base64
import java.nio.charset.StandardCharsets

fun String.base64ToPlain(): String {
    val data: ByteArray = Base64.decode(this, Base64.DEFAULT)
    return String(data, StandardCharsets.UTF_8)
}

