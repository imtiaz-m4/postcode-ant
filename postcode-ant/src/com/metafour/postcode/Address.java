package com.metafour.postcode;

import org.simpleframework.xml.*;

@Root(name = "Address")
@Order(elements = { "Postcode", "Town", "Country", "Road", "Building", "PostBox", "District", "State", "Department", "Organization", "UDPRN",
		"PostcodeType", "SUOI", "DPS", "Latitude", "Longitude", "Xcoordinate", "Ycoordinate" })
public class Address {

	@Element(name = "Postcode", required = true)
	protected String postcode;
	@Element(name = "Town", required = true)
	protected String town;
	@Element(name = "Country", required = true)
	protected String country;
	@Element(name = "Road", required = true)
	protected Road road;
	@Element(name = "Building", required = true)
	protected Building building;
	@Element(name = "PostBox", required = false)
	protected String postBox;
	@Element(name = "District", required = false)
	protected District district;
	@Element(name = "State", required = false)
	protected String state;
	@Element(name = "Department", required = false)
	protected String department;
	@Element(name = "Organization", required = false)
	protected String organization;
	@Element(name = "UDPRN")
	protected int udprn;
	@Element(name = "PostcodeType", required = true)
	protected String postcodeType;
	@Element(name = "SUOI", required = false)
	protected String suoi;
	@Element(name = "DPS", required = true)
	protected String dps;
	@Element(name = "Latitude", required = false)
	protected String latitude;
	@Element(name = "Longitude", required = false)
	protected String longitude;
	@Element(name = "Xcoordinate", required = false)
	protected int xcoordinate;
	@Element(name = "Ycoordinate", required = false)
	protected int ycoordinate;

	public String getAddressLine1() {
		String s = "";

		Building b = building;
		if (b != null) {
			s += b.getSubBuilding();
			if (!b.getName().isEmpty()) {
				s = b.getName() + (s.isEmpty() ? "" : " (" + s + ")");
			}
			if (!s.isEmpty()) s += ", ";
			if (b.getNumber() > 0) s += b.getNumber();
		}
		if (road != null) {
			if (road.getStreet() != null) s += " " + road.getStreet() + ",";
			s += " " + road.getValue();
		}
		return s + ", " + town;
	}

	public String getPostcode() {
		return postcode;
	}

	public void setPostcode(String value) {
		this.postcode = value;
	}

	public String getTown() {
		return town;
	}

	public void setTown(String value) {
		this.town = value;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String value) {
		this.country = value;
	}

	public Road getRoad() {
		return road;
	}

	public void setRoad(Road value) {
		this.road = value;
	}

	public Building getBuilding() {
		return building;
	}

	public void setBuilding(Building value) {
		this.building = value;
	}

	public String getPostBox() {
		return postBox;
	}

	public void setPostBox(String value) {
		this.postBox = value;
	}

	public District getDistrict() {
		return district;
	}

	public void setDistrict(District value) {
		this.district = value;
	}

	public String getState() {
		return state;
	}

	public void setState(String value) {
		this.state = value;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String value) {
		this.department = value;
	}

	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String value) {
		this.organization = value;
	}

	public int getUDPRN() {
		return udprn;
	}

	public void setUDPRN(int value) {
		this.udprn = value;
	}

	public String getPostcodeType() {
		return postcodeType;
	}

	public void setPostcodeType(String value) {
		this.postcodeType = value;
	}

	public String getSUOI() {
		return suoi;
	}

	public void setSUOI(String value) {
		this.suoi = value;
	}

	public String getDPS() {
		return dps;
	}

	public void setDPS(String value) {
		this.dps = value;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String value) {
		this.latitude = value;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String value) {
		this.longitude = value;
	}

	public int getXcoordinate() {
		return xcoordinate;
	}

	public void setXcoordinate(int value) {
		this.xcoordinate = value;
	}

	public int getYcoordinate() {
		return ycoordinate;
	}

	public void setYcoordinate(int value) {
		this.ycoordinate = value;
	}

	public static class Building {

		@Text(required = false)
		protected String value;
		@Attribute(name = "Number", required = false)
		protected int number;
		@Attribute(name = "Name", required = false)
		protected String name;
		@Attribute(name = "SubBuilding", required = false)
		protected String subBuilding;

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}

		public int getNumber() {
			return number;
		}

		public void setNumber(int value) {
			this.number = value;
		}

		public String getName() {
			return name;
		}

		public void setName(String value) {
			this.name = value;
		}

		public String getSubBuilding() {
			return subBuilding;
		}

		public void setSubBuilding(String value) {
			this.subBuilding = value;
		}

		@Override
		public String toString() {
			return "Building [" + "number=" + number + ", " + (name != null ? "name=" + name + ", " : "")
					+ (subBuilding != null ? "subBuilding=" + subBuilding : "") + "]";
		}

	}

	public static class District {

		@Text(required = false)
		protected String value;
		@Attribute(name = "Area", required = false)
		protected String area;

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}

		public String getArea() {
			return area;
		}

		public void setArea(String value) {
			this.area = value;
		}

		@Override
		public String toString() {
			return "District [" + (value != null ? "value=" + value + ", " : "") + (area != null ? "area=" + area : "") + "]";
		}

	}

	public static class Road {

		@Text
		protected String value;
		@Attribute(name = "Street", required = false)
		protected String street;

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}

		public String getStreet() {
			return street;
		}

		public void setStreet(String value) {
			this.street = value;
		}

		@Override
		public String toString() {
			return "Road [" + (value != null ? "value=" + value + ", " : "") + (street != null ? "street=" + street : "") + "]";
		}

	}

	@Override
	public String toString() {
		return "\nAddress [" + "line1=" + getAddressLine1() + ", " + (postcode != null ? "postcode=" + postcode + ", " : "")
				+ (town != null ? "town=" + town + ", " : "") + (country != null ? "country=" + country + ", " : "")
				+ (road != null ? "road=" + road + ", " : "") + (building != null ? "building=" + building + ", " : "")
				+ (postBox != null ? "postBox=" + postBox + ", " : "") + (district != null ? "district=" + district + ", " : "")
				+ (state != null ? "state=" + state + ", " : "") + (department != null ? "department=" + department + ", " : "")
				+ (organization != null ? "organization=" + organization + ", " : "") + "udprn=" + udprn + ", "
				+ (postcodeType != null ? "postcodeType=" + postcodeType + ", " : "") + (suoi != null ? "suoi=" + suoi + ", " : "")
				+ (dps != null ? "dps=" + dps + ", " : "") + (latitude != null ? "latitude=" + latitude + ", " : "")
				+ (longitude != null ? "longitude=" + longitude + ", " : "") + "xcoordinate=" + xcoordinate + ", ycoordinate=" + ycoordinate + "]";
	}
}
