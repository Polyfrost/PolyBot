package cc.polyfrost.crashylizer

import dev.kord.core.Kord
import dev.kord.gateway.Intent
import dev.kord.gateway.PrivilegedIntent

suspend fun main() {
    val kord = Kord(
        System.getenv("TOKEN") ?: error("No token provided with the TOKEN environment variable")
    )

    kord.login {
        @OptIn(PrivilegedIntent::class)
        intents {
            +Intent.MessageContent
            +Intent.GuildMessages
        }
    }
}