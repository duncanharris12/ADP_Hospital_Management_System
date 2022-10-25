package za.ac.cput.View;

import com.google.gson.Gson;
import okhttp3.*;
import za.ac.cput.Entity.Appointment;
import za.ac.cput.Entity.Patient;
import za.ac.cput.Entity.TestPatient;
import za.ac.cput.Factory.PatientFactory;
import za.ac.cput.Factory.TestPatientFactory;

import java.io.IOException;

public class OkHttp {
    public static final MediaType JSON = MediaType.get("application/json; charset=utf-8");
    private static OkHttpClient client = new OkHttpClient();
    public static String readRequest(String url) throws IOException {
        Request request=new Request.Builder().url(url).get().build();
        try( Response response =client.newCall(request).execute()){

            return response.body().string(); }
    }

    //Saves the patient object into the database
    public static void save(String patientID, String patientName, long phone_number, int age,String sex, String address, String patientPassword) throws IOException{

        String URL="http://localhost:8080/hospital-management/patient/save";


        Patient patientObj= PatientFactory.createPatient(patientID,patientName,address,phone_number,sex,age,patientPassword);
        Gson gn =new Gson();
        String jrequestBody=gn.toJson(patientObj);
        String saved= post(URL,jrequestBody);
        String success= (saved)!=null ? "patient saved ": "Not saved";
        System.out.println(success);
        System.out.println(saved.toString());

    }


    //Saves the test patient object into the database
    public static void storeTest(String testID, String testName) throws IOException {
         String URL = "http://localhost:8080/hospital-management/testPatient/save_testPatient";
            Patient patient = null;// = PatientFactory.createPatient(patientID,patientName,address,phone_number,sex,age,patientPassword);
            TestPatient testPatient = TestPatientFactory.createTestPatient(testID,testName,patient);
            Gson g = new Gson();
            String jsonString = g.toJson(testPatient);
            String tp = post(URL, jsonString);

    }


    public  static String post(final String url, String json) throws IOException {
        RequestBody body = RequestBody.create(JSON, json);

        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        try (Response response = client.newCall(request).execute()) {
            return response.body().string();
        }
    }
    //Gets object from the database by ID
    public static Patient readById(String patientID) throws IOException{

        String URL="http://localhost:8080/hospital-management/patient/readPatient/"+patientID;
        String jsonObjt=readRequest(URL);
        Gson gn = new Gson();
        Patient p=gn.fromJson(jsonObjt, Patient.class);
        System.out.println(p.toString());
        String success =(p.toString()==null) ? "not read":"reading successful";
        System.out.println(success);
        return p;
    }

    public static Appointment readAppointmentById(String id)throws IOException{
        String URL="http://localhost:8080/hospital-management/appointment/getAdmin/"+id;
        String jsonObjt=readRequest(URL);
        Gson gn = new Gson();
        Appointment a=gn.fromJson(jsonObjt, Appointment.class);
        System.out.println(a.toString());
        String success =(a.toString()==null) ? "not read":"reading successful";
        System.out.println(success);
        return a;
    }

    public static Appointment readMedicalRecordById(String id)throws IOException{
        String URL="http://localhost:8080/hospital-management/medicalRecords/getMedicalRecords/"+id;
        String jsonObjt=readRequest(URL);
        Gson gn = new Gson();
        Appointment mr=gn.fromJson(jsonObjt, Appointment.class);
        System.out.println(mr.toString());
        String success =(mr.toString()==null) ? "not read":"reading successful";
        System.out.println(success);
        return mr;
    }


    public static Appointment readMedicationById(String id)throws IOException{
        String URL="http://localhost:8080/hospital-management/medication/getMedication/"+id;
        String jsonObjt=readRequest(URL);
        Gson gn = new Gson();
        Appointment m=gn.fromJson(jsonObjt, Appointment.class);
        System.out.println(m.toString());
        String success =(m.toString()==null) ? "not read":"reading successful";
        System.out.println(success);
        return m;
    }

    public static Appointment readTestResultsById(String id)throws IOException{
        String URL="http://localhost:8080/hospital-management/testResults/getTestResults/"+id;
        String jsonObjt=readRequest(URL);
        Gson gn = new Gson();
        Appointment tr=gn.fromJson(jsonObjt, Appointment.class);
        System.out.println(tr.toString());
        String success =(tr.toString()==null) ? "not read":"reading successful";
        System.out.println(success);
        return tr;
    }



}
