/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dctw;

/**
 *
 * @author DJAWED
 */
public class Localisation {
    private double nuisance;
    private double bruit;
    private double impact;
    private double geotechnique;
    private double equipement;
    private double accessibilite;
    private double climat;

    public Localisation() {
    }

    public Localisation(double nuisance, double bruit, double impact, double geotechnique, double equipement, double accessibilite, double climat) {
        this.nuisance = nuisance;
        this.bruit = bruit;
        this.impact = impact;
        this.geotechnique = geotechnique;
        this.equipement = equipement;
        this.accessibilite = accessibilite;
        this.climat = climat;
    }

    public double getNuisance() {
        return nuisance;
    }

    public void setNuisance(double nuisance) {
        this.nuisance = nuisance;
    }

    public double getBruit() {
        return bruit;
    }

    public void setBruit(double bruit) {
        this.bruit = bruit;
    }

    public double getImpact() {
        return impact;
    }

    public void setImpact(double impact) {
        this.impact = impact;
    }

    public double getGeotechnique() {
        return geotechnique;
    }

    public void setGeotechnique(double geotechnique) {
        this.geotechnique = geotechnique;
    }

    public double getEquipement() {
        return equipement;
    }

    public void setEquipement(double equipement) {
        this.equipement = equipement;
    }

    public double getAccessibilite() {
        return accessibilite;
    }

    public void setAccessibilite(double accessibilite) {
        this.accessibilite = accessibilite;
    }

    public double getClimat() {
        return climat;
    }

    public void setClimat(double climat) {
        this.climat = climat;
    }
}

