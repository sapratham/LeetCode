class Solution {
    public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        int sumEnergy = 0;
        int totalhour = 0;
        for(int i : energy){
            sumEnergy += i;
        }
        totalhour += (sumEnergy - initialEnergy >= 0)? sumEnergy - initialEnergy + 1 : 0;
        
        for(int i = 0 ; i < experience.length ; i++){
            if(initialExperience <= experience[i]){
                totalhour += experience[i] + 1 - initialExperience;
                initialExperience = experience[i] + 1;
            }
            initialExperience += experience[i];
        }
        return totalhour;
    }
}