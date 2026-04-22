package oop;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class WriteJSON {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		JSONObject student1 = new JSONObject();
		student1.put("StudentName", "Mike");
		student1.put("Grade", "2nd");
		student1.put("Location", "Warsaw");
		
		JSONObject student2 = new JSONObject();
		student2.put("StudentName", "Jane");
		student2.put("Grade", "3rd");
		student2.put("Location", "Warsaw");
		
		System.out.println(student1.toJSONString());
		System.out.println(student2.toJSONString());
		
		JSONArray studentDetails = new JSONArray();
		studentDetails.add(student1);
		studentDetails.add(student2);
		
		System.out.println(studentDetails.toJSONString());
		
		JSONObject details = new JSONObject();
		details.put("studentDetails", studentDetails);
		
		System.out.println(details.toJSONString());
	}
}
