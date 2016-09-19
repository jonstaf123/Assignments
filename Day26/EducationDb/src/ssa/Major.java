package ssa;

public class Major {
	int id;
	String description;
	int requiredSat;

	@Override
	public String toString() {
		String msg = String.format("%3d %-20s %-4d", this.id, this.description, this.requiredSat);
		return msg;
	}

}
