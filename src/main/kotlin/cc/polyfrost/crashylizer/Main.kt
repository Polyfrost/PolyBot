package cc.polyfrost.crashylizer

import cc.polyfrost.crashylizer.extensions.PingExtension
import com.kotlindiscord.kord.extensions.ExtensibleBot
import com.kotlindiscord.kord.extensions.utils.env
import dev.kord.gateway.Intent
import dev.kord.gateway.PrivilegedIntent

private val token = env("TOKEN")

suspend fun main() {
    val bot = ExtensibleBot(token) {
        @OptIn(PrivilegedIntent::class)
        intents(false) {
            +Intent.GuildMessages
            +Intent.DirectMessages
            +Intent.MessageContent
        }

        presence {
            watching("minecraft crash")
        }

        extensions {
            add(::PingExtension)
        }
    }

    bot.start()
}