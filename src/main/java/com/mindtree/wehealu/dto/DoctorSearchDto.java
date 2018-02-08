package com.mindtree.wehealu.dto;

public class DoctorSearchDto {

	private String doctorName;
	
	private String contact;

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	@Override
	public String toString() {
		return "DoctorSearchDto [doctorName=" + doctorName + ", contact=" + contact + "]";
	}
	
	
}
