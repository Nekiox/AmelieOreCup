package fr.nekiox.mineral.Scoreboard.newapi;

import fr.nekiox.mineral.Core.MCPlayer;
import fr.nekiox.mineral.Translation.Lang;
import fr.nekiox.mineral.mineralcontest;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class ScoreboardAPI {

    private static ArrayList<Player> playersWithScoreboard;

    // Joueurs ayant activé le mode streamer (coordonnées cachées)
    private static Set<UUID> streamerHiddenPlayers = new HashSet<>();

    public static String prefix = "» ";


    public static void createScoreboard(Player player, boolean force){

        // Récupération du MCPlayer
        MCPlayer mcPlayer = mineralcontest.plugin.getMCPlayer(player);


        // Création d'une liste de joueurs ayant un scoreboard
        if(playersWithScoreboard == null) playersWithScoreboard = new ArrayList<>();

        if(doesPlayerHaveHUD(player) && !force) {
            return;
        }

        clearScoreboard(player);
        Scoreboard scoreboard = player.getScoreboard();

        int position = 16;

        addScoreboardText(player, ChatColor.GOLD + "Groupe", position--);
        registerNewObjective(player, ScoreboardFields.SCOREBOARD_GROUP_STATE, prefix + mcPlayer.getGroupe().getEtatPartie().getNom(), position--);

        addEmptyLine(player, position--);

        addScoreboardText(player, ChatColor.GOLD + "Joueurs", position--);
        registerNewObjective(player, ScoreboardFields.SCOREBOARD_PLAYER_COUNT, prefix + mcPlayer.getGroupe().getPlayerCount(), position--);

        addEmptyLine(player, position--);

        addScoreboardText(player, ChatColor.GOLD + "Etat", position--);
        registerNewObjective(player, ScoreboardFields.SCOREBOARD_PLAYER_READY, prefix, position--);

        if(mcPlayer.getGroupe().getAdmins().size() > 0) {
            Player admin = mcPlayer.getGroupe().getAdmins().getFirst();
            addEmptyLine(player, position--);
            addScoreboardText(player, ChatColor.RED + "Admin", position--);
            registerNewObjective(player, ScoreboardFields.SCOREBOARD_ADMINS, prefix + admin.getDisplayName(), position--);

        }

        player.setScoreboard(scoreboard);
        playersWithScoreboard.add(player);

        if(mcPlayer.getGroupe().getGame().isPlayerReady(player)) updateField(player, ScoreboardFields.SCOREBOARD_PLAYER_READY, prefix + ChatColor.GREEN + Lang.ready_tag.toString());
        else updateField(player, ScoreboardFields.SCOREBOARD_PLAYER_READY, prefix + ChatColor.RED + Lang.not_ready_tag.toString());


    }

    public static void updateField(Player player, ScoreboardFields cle, String valeur){
        if(playersWithScoreboard == null) playersWithScoreboard = new ArrayList<>();
        if(!doesPlayerHaveHUD(player)) return;


        // On mets à jour le scoreboard du joueur
        Scoreboard scoreboard = player.getScoreboard();
        scoreboard.getObjective(ScoreboardFields.SCOREBOARD_TITLE.toString());


        // On mets le nombre de joueur en ligne
        Team team = scoreboard.getTeam(cle.toString());
        if(team == null) return;
        team.setPrefix(valeur);


    }

    /**
     * Méthode permettabt de clear le scoreboard d'un joueur
     * @param joueur
     */
    public static void clearScoreboard(Player joueur){
        // Création d'un nouveau scoreboard
        Scoreboard scoreboard = Bukkit.getScoreboardManager().getNewScoreboard();

        // On traite les paramètres passé
        // Premier element, le titre
        String scoreboardTitle = Lang.title.toString();


        Objective objective = scoreboard.registerNewObjective(ScoreboardFields.SCOREBOARD_TITLE.toString(), "dummy", scoreboardTitle);
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);

        joueur.setScoreboard(scoreboard);
    }

    /**
     * Permet d'enregistrer un element dans le scoreboard d'un joueur
     * @param player
     * @param fields
     * @param value
     * @param position
     */
    public static void registerNewObjective(Player player, ScoreboardFields fields, String value, int position) {
        Scoreboard scoreboard = player.getScoreboard();

        Objective objective = scoreboard.getObjective(ScoreboardFields.SCOREBOARD_TITLE.toString());

        Team equipe = objective.getScoreboard().registerNewTeam(fields.toString());
        equipe.addEntry(fields.getUniqueColor());
        equipe.setPrefix(value);

        objective.getScore(fields.getUniqueColor()).setScore(position);

        player.setScoreboard(scoreboard);
    }

    public static void addScoreboardText(Player player, String text, int position) {
        Scoreboard scoreboard = player.getScoreboard();

        Objective objective = scoreboard.getObjective(ScoreboardFields.SCOREBOARD_TITLE.toString());


        Score score = objective.getScore(text);

        score.setScore(position);

        player.setScoreboard(scoreboard);
    }

    public static void addEmptyLine(Player player, int position) {
        Scoreboard scoreboard = player.getScoreboard();

        Objective objective = scoreboard.getObjective(ScoreboardFields.SCOREBOARD_TITLE.toString());


        String space = "";
        for(int i = 0; i < position; ++i)
            space += " ";

        Score score = objective.getScore(space);

        score.setScore(position);

        player.setScoreboard(scoreboard);
    }


    private static boolean doesPlayerHaveHUD(Player player){
        for(Player player1 : playersWithScoreboard)
            if(player1.getUniqueId().equals(player.getUniqueId())) return true;

        return false;
    }

    public static boolean isStreamerMode(Player player) {
        if (player == null) return false;
        return streamerHiddenPlayers.contains(player.getUniqueId());
    }

    public static boolean toggleStreamerMode(Player player) {
        if (player == null) return false;
        UUID id = player.getUniqueId();
        if (streamerHiddenPlayers.contains(id)) {
            streamerHiddenPlayers.remove(id);
            return false;
        } else {
            streamerHiddenPlayers.add(id);
            return true;
        }
    }

    public static void setStreamerMode(Player player, boolean enabled) {
        if (player == null) return;
        UUID id = player.getUniqueId();
        if (enabled) streamerHiddenPlayers.add(id);
        else streamerHiddenPlayers.remove(id);
    }

}
