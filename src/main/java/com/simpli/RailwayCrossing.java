package com.simpli;

public class RailwayCrossing {
	private int id;
	private String name;
	private String address;
	private String landmark;
	private String trainSchedule;
	private String personInCharge;
	private String status;

	public RailwayCrossing() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RailwayCrossing(int id, String name, String address, String landmark, String trainSchedule,
			String personInCharge, String status) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.landmark = landmark;
		this.trainSchedule = trainSchedule;
		this.personInCharge = personInCharge;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getLandmark() {
		return landmark;
	}

	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}

	public String getTrainSchedule() {
		return trainSchedule;
	}

	public void setTrainSchedule(String trainSchedule) {
		this.trainSchedule = trainSchedule;
	}

	public String getPersonInCharge() {
		return personInCharge;
	}

	public void setPersonInCharge(String personInCharge) {
		this.personInCharge = personInCharge;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setId(String string) {
		// TODO Auto-generated method stub

	}
}