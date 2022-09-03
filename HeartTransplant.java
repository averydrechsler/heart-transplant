/**
 * 
 * HeartTransplant class
 * 
 * @author Ana Paula Centeno
 * @author Haolin (Daniel) Jin
 * @author Avery Drechsler, and130
 */
public class HeartTransplant {

    // patient array, each Patient is read from the data file
    private Patient[] patients;

    // SurvivabilityByAge array, each rate is read from data file
    private SurvivabilityByAge survivabilityByAge;

    // SurvivabilityByCause array, each rate is read from data file
    private SurvivabilityByCause survivabilityByCause;

    /*
     * Default constructor
     * Initializes patients to null.
     * Initializes survivabilityByAge to null.
     * Initializes survivabilityByCause to null. 
     */
    public HeartTransplant() {
        patients = null;
        survivabilityByAge = null;
        survivabilityByCause = null;

        // WRITE YOUR CODE HERE
    }

    /*
     * Returns patients
     */
    public Patient[] getPatients() {
        return patients;
        // WRITE YOUR CODE HERE
     } 

    /*
     * Returns survivabilityByAge
     */
    public SurvivabilityByAge getSurvivabilityByAge() {
        return survivabilityByAge;
        // WRITE YOUR CODE HERE
    }

    /*
     * Returns survivabilityByCause
     */
    public SurvivabilityByCause getSurvivabilityByCause() {
        return survivabilityByCause;
        // WRITE YOUR CODE HERE
    }

    /*
     * 1) Initialize the instance variable patients array with numberOfLines length.
     * 
     * 2) Reads from the command line data file, use StdIn.readInt() to read an integer.
     *    File Format: 
     *      ID, ethnicity, Gender, Age, Cause, Urgency, State of health
     * 
     *    Each line refers to one Patient, all values are integers.
     * 
     */
    public void readPatients (int numberOfLines) {
        patients = new Patient[numberOfLines];
        
        StdIn.readLine();
        int[] newData = new int[7];
        for(int i = 0; i < patients.length; i++)
        {
            for(int j = 0; j < 7; j++)
            {
                newData[j] = Integer.parseInt(StdIn.readString());
            }
            patients[i] = new Patient(newData[0], newData[1], newData[2], newData[3], newData[4], newData[5], newData[6]);
        }
        // WRITE YOUR CODE HERE
    }

    /*
     * 1) Initialize the instance variable survivabilityByAge with a new survivabilityByAge object.
     * 
     * 2) Reads from the command line file to populate the object. 
     *    Use StdIn.readInt() to read an integer and StdIn.readDouble() to read a double.
     * 
     *    File Format: Age YearsPostTransplant Rate
     *    Each line refers to one survivability rate by age.
     * 
     */
    public void readSurvivabilityByAge (int numberOfLines) {
        survivabilityByAge = new SurvivabilityByAge();
        for(int i = 0; i < numberOfLines; i++){
        int age = StdIn.readInt();
        int year = StdIn.readInt();
        double rate = StdIn.readDouble();
        survivabilityByAge.addData(age, year, rate); 
        }
        // WRITE YOUR CODE HERE
    }

    /*
     * 1) Initialize the instance variable survivabilityByCause with a new survivabilityByCause object.
     * 
     * 2) Reads from the command line file to populate the object. Use StdIn.readInt() to read an 
     *    integer and StdIn.readDouble() to read a double.
     * 
     *    File Format: Cause YearsPostTransplant Rate
     *    Each line refers to one survivability rate by cause.
     * 
     */
    public void readSurvivabilityByCause (int numberOfLines) {
        survivabilityByCause = new SurvivabilityByCause(); 
        for(int i = 0; i < numberOfLines; i++){
            int cause =  StdIn.readInt();
            int year = StdIn.readInt();
            double rate = StdIn.readDouble();
            survivabilityByCause.addData(cause, year, rate);
        }
        // WRITE YOUR CODE HERE
    }
    
    /*
     * Returns a Patient array containing the patients, 
     * from the patients array, that have age above the parameter age.
     * 
     * The return array has to be completely full with no empty
     * spots, that is the array size should be equal to the number
     * of Patients with age above the parameter age.
     * 
     * Return null if there is no Patient with age above the 
     * parameter age.
     */ 
    public Patient[] getPatientsWithAgeAbove(int age) {
        int index = 0;
        int newIndex = 0;
        for(int i = 0; i < patients.length; i++){
            Patient newPatient = patients[i];
            int ageOfPatient = newPatient.getAge();
            if(ageOfPatient >= age){
              index++;
            }
        }
        Patient[] patientAge = new Patient[index];
        for(int i = 0; i < patients.length; i++){
            Patient newPatient = patients[i];
            int ageOfPatient = newPatient.getAge();
            if(ageOfPatient >= age){
              patientAge[newIndex] = newPatient;
              newIndex++;
            }
        }if(patientAge.length == 0){
         return null;
        }
        return patientAge;
        // WRITE YOUR CODE HERE
    }

    /*
     * Returns a Patient array containing the patients, from the patients array, 
     * that have the heart condition cause equal to the parameter cause.
     * 
     * The return array has to be completely full with no empty
     * spots, that is the array size should be equal to the number
     * of Patients with the heart condition cause equal to the parameter cause.
     * 
     * Return null if there is no Patient with the heart condition cause 
     * equal to the parameter cause.
     */ 
    public Patient[] getPatientsByHeartConditionCause(int cause) {
        int index = 0;
        int newIndex = 0;
        for(int i = 0; i < patients.length; i++){
            Patient newPatient = patients[i];
            int causeOfPatient = newPatient.getCause();
            if(causeOfPatient >= cause){
              index++;
            }
        }
        Patient[] heartConditionCause = new Patient[index];
        for(int i = 0; i < patients.length; i++)
        {
            Patient newPatient = patients[i];
            int causeOfPatient = newPatient.getCause();
            if(causeOfPatient >= cause){
              heartConditionCause[newIndex] = newPatient;
              newIndex++;
            }
        }if(heartConditionCause.length == 0){
         return null;
        }
        return heartConditionCause;
        // WRITE YOUR CODE HERE
    }

    /*
     * Returns a Patient array containing patients, from the patients array,
     * that have the state of health equal to the parameter state.
     * 
     * The return array has to be completely full with no empty
     * spots, that is the array size should be equal to the number
     * of Patients with the state of health equal to the parameter state.
     * 
     * Return null if there is no Patient with the state of health 
     * equal to the parameter state.
     */ 
    public Patient[] getPatientsByUrgency(int urgency) {
        int index = 0;
        int newIndex = 0;
        for(int i = 0; i < patients.length; i++){
            Patient newPatient = patients[i];
            int patientUrgency = newPatient.getStateOfHealth();
            if(patientUrgency >= urgency){
              index++;
            }
        }
        Patient[] patientStateOfHealth = new Patient[index];
        for(int i = 0; i < patients.length; i++){
            Patient newPatient = patients[i];
            int patientUrgency = newPatient.getStateOfHealth();
            if(patientUrgency == urgency){
              patientStateOfHealth[newIndex] = newPatient; 
              index++;
            }
        }if(patientStateOfHealth.length == 0){
         return null;
        }
        return patientStateOfHealth;
        // WRITE YOUR CODE HERE
    }

    /*
     * Assume there is a heart available for transplantation surgery.
     * Also assume that the heart is of the same blood type as the
     * Patients on the patients array.
     * This method finds the Patient to be the recepient of this
     * heart.
     * 
     * The method returns a Patient from the patients array with
     * he highest potential for survivability after the transplant.
     * 
     * Assume the patient returned by this method will receive a heart,
     * therefore the Patient will no longer need a heart.
     * 
     * There is no correct solution, you may come up with any 
     * function to find the patient with the highest potential 
     * for survivability after the transplant.
     */ 
    public Patient getPatientForTransplant () {
        Patient person[] = new Patient[patients.length];
        int p = 0;
        for(int i = 0; i < patients.length; i++){
            person[i] = patients[i]; 
            if(person[i].getNeedHeart() == true){
                p = i; 
            }
        }
        person[p].setNeedHeart(false);
        return person[p]; 
    }
	// WRITE YOUR CODE HERE
}
