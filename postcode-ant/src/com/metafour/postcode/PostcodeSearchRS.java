package com.metafour.postcode;

import java.util.ArrayList;
import java.util.List;
import org.simpleframework.xml.*;

@Root(name = "PostcodeSearchResponse")
public class PostcodeSearchRS {

	@ElementList(inline = true, required = false)
	protected List<Address> address;
	@Element(name = "Status", required = true)
	protected Status status;

	public List<Address> getAddress() {
		if (address == null) {
			address = new ArrayList<Address>();
		}
		return this.address;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status value) {
		this.status = value;
	}

	public boolean isOK() {
		return getStatus().getCode() == 0;
	}

	public static class Status {

		@Text
		protected String value;
		@Attribute(name = "Code")
		protected int code;

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}

		public int getCode() {
			return code;
		}

		public void setCode(int value) {
			this.code = value;
		}

		@Override
		public String toString() {
			return "\nStatus [" + code + "]: " + value;
		}

	}

	@Override
	public String toString() {
		return "PostcodeSearchResponse [addresslist=" + address + ", status=" + status + "]";
	}

}
