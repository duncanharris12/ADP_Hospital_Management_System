package za.ac.cput.Views;

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










}
