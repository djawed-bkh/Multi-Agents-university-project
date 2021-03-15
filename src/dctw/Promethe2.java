/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dctw;


import static java.lang.Math.abs;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author DJAWED
 */
public class Promethe2 {
  
    // etape 1          normalisation de la matrice en beneficial(maximiser) et non beneficial(minimiser)
    public static ArrayList normalisation(ArrayList<Localisation> matriceInitiale){
        ArrayList<Localisation> MatriceNormalise=new ArrayList<>();
        
      
        // chercher le max et le min de chaque colonne
                    // Nuisance
        Localisation LocMaxNuisance=Collections.max(matriceInitiale,Comparator.comparing(t -> t.getNuisance()));
        Localisation LocMinNuisance=Collections.min(matriceInitiale,Comparator.comparing(t -> t.getNuisance()));
        
        double MaxNuisance=LocMaxNuisance.getNuisance();
        double MinNuisance=LocMinNuisance.getNuisance();

        //Bruit
                    
        Localisation LocMaxBruit=Collections.max(matriceInitiale,Comparator.comparing(t -> t.getBruit()));
        Localisation LocMinBruit=Collections.min(matriceInitiale,Comparator.comparing(t -> t.getBruit()));
        double MaxBruit=LocMaxBruit.getBruit();
        double MinBruit=LocMinBruit.getBruit();
        
                    //Impact
        Localisation ImpactMax=Collections.max(matriceInitiale,Comparator.comparing(t -> t.getImpact()));
        Localisation ImpactMin=Collections.min(matriceInitiale,Comparator.comparing(t -> t.getImpact()));
        double MaxImpact=ImpactMax.getImpact();
        double MinImpact=ImpactMin.getImpact();
                    
                    
                    //Géotechnique
        Localisation GeotechniqueMax=Collections.max(matriceInitiale,Comparator.comparing(t -> t.getGeotechnique()));
        Localisation GeotechniqueMin=Collections.min(matriceInitiale,Comparator.comparing(t -> t.getGeotechnique()));
        double MaxGeo=GeotechniqueMax.getGeotechnique();
        double MinGeo=GeotechniqueMin.getGeotechnique();
        
        //Equipement
        Localisation EquipementMax=Collections.max(matriceInitiale,Comparator.comparing(t -> t.getEquipement()));
        Localisation EquipementMin=Collections.min(matriceInitiale,Comparator.comparing(t -> t.getEquipement()));
        double MaxEquipement=EquipementMax.getEquipement();
        double MinEquipement=EquipementMin.getEquipement();
        
        //Accesibilite
        Localisation AccesMax=Collections.max(matriceInitiale,Comparator.comparing(t -> t.getAccessibilite()));
        Localisation AccesMin=Collections.min(matriceInitiale,Comparator.comparing(t -> t.getAccessibilite()));
        double MaxAcces=AccesMax.getAccessibilite();
        double MinAcces=AccesMin.getAccessibilite();
        
        //Climat
        Localisation ClimatMax=Collections.max(matriceInitiale,Comparator.comparing(t -> t.getClimat()));
        Localisation ClimatMin=Collections.min(matriceInitiale,Comparator.comparing(t -> t.getClimat()));
        double MaxClimat=ClimatMax.getClimat();
        double MinClimat=ClimatMin.getClimat();
        
        
        
        
        
        
        //normalisation
        for(int i=0;i<matriceInitiale.size();i++){
            MatriceNormalise.add(new Localisation(abs((MinNuisance-matriceInitiale.get(i).getNuisance())/(MaxNuisance-MinNuisance)),abs((MinBruit-matriceInitiale.get(i).getBruit())/(MaxBruit-MinBruit)),
                    abs((MinImpact-matriceInitiale.get(i).getImpact())/(MaxImpact-MinImpact)),abs((MinGeo-matriceInitiale.get(i).getGeotechnique())/(MaxGeo-MinGeo)),
            abs((MinEquipement-matriceInitiale.get(i).getEquipement())/(MaxEquipement-MinEquipement)),abs((MinAcces-matriceInitiale.get(i).getAccessibilite())/(MaxAcces-MinAcces)),
            abs((MinClimat-matriceInitiale.get(i).getClimat())/(MaxClimat-MinClimat))));
        }
        
        return MatriceNormalise;
    }
    
    
    // etape 2          calcul des differences dans le tableau
    
    public static  ArrayList calculDifference(ArrayList<Localisation> MatriceNormalisee){
        // caluler les differences
        ArrayList<Localisation> MatriceDiffercnes= new ArrayList();
        
        
        for(int i=0;i<MatriceNormalisee.size();i++){
           for(int j=0;j<MatriceNormalisee.size();j++){
             
               if(j!=i){
                       MatriceDiffercnes.add(new Localisation(MatriceNormalisee.get(i).getNuisance()-MatriceNormalisee.get(j).getNuisance(),
                       MatriceNormalisee.get(i).getBruit()-MatriceNormalisee.get(j).getBruit(),
                       MatriceNormalisee.get(i).getImpact()-MatriceNormalisee.get(j).getImpact(),
                       MatriceNormalisee.get(i).getGeotechnique()-MatriceNormalisee.get(j).getGeotechnique(),
                       MatriceNormalisee.get(i).getEquipement()-MatriceNormalisee.get(j).getEquipement(),
                       MatriceNormalisee.get(i).getAccessibilite()-MatriceNormalisee.get(j).getAccessibilite(),
                       MatriceNormalisee.get(i).getClimat()-MatriceNormalisee.get(j).getClimat()));
                   
                        }
               
               
           }
            
            
        }
        return MatriceDiffercnes;
    }
    
    
    // etape 3 remplacer les valeurs négatives par 0 et garder les autres
     public static  ArrayList calculPreference(ArrayList<Localisation> MatriceDiffercnes){
        ArrayList<Localisation> MatricePreference= new ArrayList();
        
         for(int i=0;i<MatriceDiffercnes.size();i++){
           if(MatriceDiffercnes.get(i).getNuisance()<0){
            MatriceDiffercnes.get(i).setNuisance(0);
           }
           if(MatriceDiffercnes.get(i).getBruit()<0){
             MatriceDiffercnes.get(i).setBruit(0);
           }
           if(MatriceDiffercnes.get(i).getImpact()<0){
            MatriceDiffercnes.get(i).setImpact(0);   
           }
           if(MatriceDiffercnes.get(i).getGeotechnique()<0){
            MatriceDiffercnes.get(i).setGeotechnique(0); 
           }
           if(MatriceDiffercnes.get(i).getEquipement()<0){
            MatriceDiffercnes.get(i).setEquipement(0); 
           }
           if(MatriceDiffercnes.get(i).getAccessibilite()<0){
            MatriceDiffercnes.get(i).setAccessibilite(0); 
           }
           if(MatriceDiffercnes.get(i).getClimat()<0){
            MatriceDiffercnes.get(i).setClimat(0); 
           }
          
         }
         MatricePreference=MatriceDiffercnes;
        return MatricePreference;
           }

    // etape 4 Multiplier le tableau par les poids
    
    public static ArrayList MultipleParPoids(ArrayList<Localisation> MatricePreference){
        ArrayList<Localisation> MatriceMultiplePoids= new ArrayList();
        
        //Poids des critéres 
        // j'ai mis les poids du décideur 1 je sais pas ila haka
        double poidsnuisance=7.51;
        double poidsbruit=13.63;
        double poidsimpact=13.63;
        double poidsgeo=13.63;
        double poidsequipement=17.2;
        double poidsacces=17.2;
        double poidsclimat=17.2;
        //Multiplier le tableau par les poids
        for(int i=0;i<MatricePreference.size();i++){
           MatriceMultiplePoids.add(new Localisation(MatricePreference.get(i).getNuisance()*poidsnuisance,MatricePreference.get(i).getBruit()*poidsbruit,
                   MatricePreference.get(i).getImpact()*poidsimpact,MatricePreference.get(i).getGeotechnique()*poidsgeo,
                   MatricePreference.get(i).getEquipement()*poidsequipement,MatricePreference.get(i).getAccessibilite()*poidsacces,
                   MatricePreference.get(i).getClimat()*poidsclimat));
           }
                
        return MatriceMultiplePoids;
    }
    
    // etape5 faire la somme du tableau
    
    public static ArrayList sommeLignes(ArrayList<Localisation> MatriceMultiplePoids){
        ArrayList<Double> somme = new ArrayList();
        // faire la somme des lignes du tableau
        for(int i=0;i<MatriceMultiplePoids.size();i++){
           somme.add(MatriceMultiplePoids.get(i).getNuisance()+MatriceMultiplePoids.get(i).getBruit()+
                   MatriceMultiplePoids.get(i).getImpact()+MatriceMultiplePoids.get(i).getGeotechnique()+
                   MatriceMultiplePoids.get(i).getEquipement()+MatriceMultiplePoids.get(i).getAccessibilite()+
                   MatriceMultiplePoids.get(i).getClimat());
           }
    
        return somme;
    }
    
    //etape 6  créer un tableau a travers les sommes
    public static double[][] MatriceSommes(ArrayList<Double> somme){
        double[][] matrice = new double[19][19];

        int i=0;

            //boucles pour inserer dans la matrice
            for (int y=0;y<18;y++){
                for(int z=0;z<18;z++){
                    if(y!=z){
                        if(i< somme.size()){
                            matrice[y][z]=somme.get(i);
                            i++;
                        }


                    }else{
                        matrice[y][z]=0;
                    }


                }
            }








        return matrice;
    }


    
    // etape 7 calcul du entering et leaving flow (c'est la moyennes des lignes et des colonnes)
    public  static double[][] Flows(double[][] matriceSomme){
        //flots sortants
        for (int y=0;y<18;y++) {
            double somme=0;
            for (int z = 0; z < 18; z++) {
                somme+=matriceSomme[y][z];

            }
            matriceSomme[y][18]=somme/17;
        }

        //flots entrants
        for (int y=0;y<18;y++) {
            double somme=0;
            for (int z = 0; z < 18; z++) {
                somme+=matriceSomme[z][y];

            }
            matriceSomme[18][y]=somme/17;
        }

        return matriceSomme;
    }
    
   // etape 8  difference entre leaving and entering flow

    public static double[]  DifferenceFLows(double[][] matriceSomme){
        double[] Difference= new double[18];


            for (int i=0;i<18;i++){
                Difference[i]=matriceSomme[i][18]- matriceSomme[18][i];

                System.out.println("Localisation "+i+" "+Difference[i]);
            }






        return Difference;
    }


    //étape N° 9 trier les resultats

    public static double[] sortingResults(double[] results){

        Arrays.sort(results);

        for (int i= results.length-1 ;i>=0;i--){
            System.out.println(" "+i+"  valeur: "+results[i]);
        }


        return results;


    }


    
    
    


    
}
