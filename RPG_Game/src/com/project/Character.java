package com.project;

public class Character {

    private String username;
    private String image;
    private String faehigkeit;
    private boolean isGay;
    private int Mana;
    private int health;

    public int getMana() {
        return Mana;
    }

    public void setMana(int mana) {
        Mana = mana;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public Character(String username, String image, String faehigkeit, boolean isGay) {
        setUsername(username);
        setImage(image);
        setFaehigkeit(faehigkeit);
        setGay(isGay);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getFaehigkeit() {
        return faehigkeit;
    }

    public void setFaehigkeit(String faehigkeit) {
        this.faehigkeit = faehigkeit;
    }

    public boolean isGay() {
        return isGay;
    }

    public void setGay(boolean gay) {
        isGay = gay;
    }

    @Override
    public String toString() {
        return "Character{" + "username='" + username + ' ' + ", image='" + image + ' ' + ", faehigkeit='" + faehigkeit + ' ' + ", isGay=" + isGay + '}';
    }
}