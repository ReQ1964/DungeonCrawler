package data;
import java.util.Random;

public class BattleMessages {

    private static final String[] DELIVER_DAMAGE_MESSAGES = {
            " lunges forward, delivering a powerful strike to ",
            " swings their weapon with great force at ",
            " launches a surprise attack on ",
            " brings their sword down with fury onto ",
            " delivers a swift kick to ",
            " hurls a fireball at ",
            " charges and slashes at ",
            " thrusts their spear towards ",
            " unleashes a devastating blow to ",
            " swings their axe with precision at ",
            " fires a deadly arrow at ",
            " delivers a crushing punch to ",
            " casts a spell that strikes ",
            " lunges with their dagger, aiming for ",
            " slashes viciously at ",
            " catches their opponent off guard, hitting ",
            " attacks with a flurry of blows on ",
            " sends a shockwave towards ",
            " smashes their shield into ",
            " delivers a critical hit to ",
            " unleashes a torrent of magic upon ",
            " strikes with an electrifying jolt at ",
            " performs a spinning kick, landing on ",
            " performs a swift maneuver, landing a blow on ",
            " strikes with an icy blast towards ",
            " charges and delivers a headbutt to ",
            " lunges forward and stabs at ",
            " ignites their fist and punches ",
            " swings wildly but lands a hit on ",
            " jabs swiftly, hitting ",
            " unleashes a series of rapid strikes on ",
            " charges and tackles ",
    };


    private static final String[] RECEIVE_DAMAGE_MESSAGES = {
            " staggers back, now at ",
            " grunts in pain, now at ",
            " winces as they absorb the blow, now at ",
            " reels from the impact, now at ",
            " takes a heavy hit and is now at ",
            " feels the force of the attack, now at ",
            " gasps, now at ",
            " is knocked off balance, now at ",
            " barely keeps standing, now at ",
            " struggles to remain upright, now at ",
            " is thrown back by the force, now at ",
            " is struck hard, now at ",
            " feels the pain radiating through, now at ",
            " stumbles but manages to hold on, now at ",
            " is hit squarely, now at ",
            " winces as they feel the damage, now at ",
            " takes a deep breath and stands at ",
            " is caught off guard, now at ",
            " shakes off the pain, now at ",
            " tries to recover, now at ",
            " is sent reeling from the attack, now at ",
            " feels their strength waning, now at ",
            " grimaces as the pain sets in, now at ",
            " gasps, struggling, now at ",
            " is battered but defiant, now at ",
            " is momentarily dazed, now at ",
            " takes a heavy blow, now at ",
            " is hit and stumbles, now at ",
            " struggles against the pain, now at ",
            " fights to maintain composure, now at ",
            " stands firm but hurt, now at ",
    };


    public static String getRandomAttackMessage(){
        Random rand = new Random();
        int arrLength = DELIVER_DAMAGE_MESSAGES.length;

        return DELIVER_DAMAGE_MESSAGES[rand.nextInt(arrLength)];
    }

    public static String getRandomReceiveDamageMessage(){
        Random rand = new Random();
        int arrLength = RECEIVE_DAMAGE_MESSAGES.length;

        return RECEIVE_DAMAGE_MESSAGES[rand.nextInt(arrLength)];
    }
}
