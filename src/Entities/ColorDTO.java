package Entities;

import org.bukkit.ChatColor;

// Class to implements the org.bukkit colors without dependencies on the entire solution.
public class ColorDTO
{
	// Light
	public String White 	=  ChatColor.WHITE.toString();
	public String Yellow 	=  ChatColor.YELLOW.toString();
	public String Red 		=  ChatColor.RED.toString();
	public String Blue 		=  ChatColor.BLUE.toString();
	public String Green 	=  ChatColor.GREEN.toString();
	public String Purple 	=  ChatColor.LIGHT_PURPLE.toString();
	
	// Dark
	public String Gray 		=  ChatColor.GRAY.toString();
	public String Gold 		=  ChatColor.GOLD.toString();
	public String DarkRed	=  ChatColor.DARK_RED.toString();
	public String DarkBlue 	=  ChatColor.DARK_BLUE.toString();
	public String DarkGreen =  ChatColor.DARK_GREEN.toString();
	public String DarkPurple=  ChatColor.DARK_PURPLE.toString();
} 
