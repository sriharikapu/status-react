(ns status-im.chat.commands.core
  (:require [status-im.chat.commands.protocol :as protocol]))

(defn validate-and-send
  "Function executing the full chain of command argument collection, validation
  and sending in the context of the current chat."
  [command cofx])

(defn send
  "Function implementing sending of command with particular arguments and
  destination (chat where the command message will be sent)."
  [command chat-id parameters cofx])

