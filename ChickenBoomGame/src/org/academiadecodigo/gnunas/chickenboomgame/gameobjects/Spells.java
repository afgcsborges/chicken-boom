package org.academiadecodigo.gnunas.chickenboomgame.gameobjects;

public enum Spells {

    FIREBALL4020("resources/images/spells/fireball/40x20/", "/fireball.png"),
    FIREBALL4930("resources/images/spells/fireball/49x30/", "/fireball.png"),
    FIREBALL6031("resources/images/spells/fireball/60x31/", "/fireball.png"),
    FIREORB6762("resources/images/spells/fireorb/67x62/", "/fireorb.png"),
    FIREORB8175("resources/images/spells/fireorb/81x75/", "/fireorb.png"),
    FIREORB9588("resources/images/spells/fireorb/95x88/", "/fireorb.png"),
    FIREWALLNARROW7013("resources/images/spells/firewall/narrow/70x13/", "/firewall.png"),
    FIREWALLNARROW8515("resources/images/spells/firewall/narrow/85x15/", "/firewall.png"),
    FIREWALLNARROW10018("resources/images/spells/firewall/narrow/100x18/", "/firewall.png"),
    FIREWALLTHICK8027("resources/images/spells/firewall/thick/80x27/", "/firewall.png"),
    FIREWALLTHICK10033("resources/images/spells/firewall/thick/100x33/", "/firewall.png"),
    FIREWALLTHICK12040("resources/images/spells/firewall/thick/120x40/", "/firewall.png"),
    FIREELEMENTAL8026("resources/images/spells/fireelemental/80x26/", "/fireelemental.png"),
    FIREELEMENTAL10033("resources/images/spells/fireelemental/100x33/", "/fireelemental.png"),
    FIREELEMENTAL12039("resources/images/spells/fireelemental/120x39/", "/fireelemental.png"); //TODO: bug for hugo

    private final String directory;
    private final String spell;

    Spells(String directory, String spell){
        this.directory = directory;
        this.spell = spell;
    }

    public String finalDirectory(Movement direction){
        String finalPath = "";
        switch (direction){
            case RIGHT:
                finalPath = "right";
                break;
            case LEFT:
                finalPath = "left";
                break;
            case DOWN:
                finalPath = "down";
                break;
            case UP:
                finalPath = "up";
                break;
        }
        return directory+finalPath+spell;
    }

}
