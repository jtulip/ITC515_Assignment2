package datamanagement;

public class cgCTL {

	cgUI cgUI;
	String cuc = null;
	Integer currentStudentID = null;
	boolean changed = false;

	public cgCTL() {
	}

	public void execute() {
		cgUI = new cgUI(this);
		cgUI.setState1(false);

		cgUI.setState2(false);
		cgUI.setCheckBtnEnable(false);
		cgUI.setChangeBtnEnable(false);
		cgUI.setMarkFieldsEditable(false);
		cgUI.setSaveBtnEnable(false);
		cgUI.Refresh3();

		ListUnitsCTL luCTL = new ListUnitsCTL();
		luCTL.listUnits(cgUI);
		cgUI.setVisible(true);
		cgUI.setState1(true);
	}

	public void unitSelected(String code) {

		if (code.equals("NONE"))
			cgUI.setState2(false);
		else {
			ListStudentsCTL lsCTL = new ListStudentsCTL();
			lsCTL.listStudents(cgUI, code);
			cuc = code;
			cgUI.setState2(true);
		}
		cgUI.setCheckBtnEnable(false);
	}

	public void studentSelected(Integer id) {
		currentStudentID = id;
		if (currentStudentID.intValue() == 0) {
			cgUI.Refresh3();
			cgUI.setCheckBtnEnable(false);
			cgUI.setChangeBtnEnable(false);
			cgUI.setMarkFieldsEditable(false);
			cgUI.setSaveBtnEnable(false);
		}

		else {
			IStudent s = StudentManager.get().getStudent(id);

			IStudentUnitRecord r = s.getUnitRecord(cuc);

			cgUI.setRecord(r);
			cgUI.setCheckBtnEnable(true);
			cgUI.setChangeBtnEnable(true);
			cgUI.setMarkFieldsEditable(false);
			cgUI.setSaveBtnEnable(false);
			changed = false;

		}
	}

	public String checkGrade(float f, float g, float h) {
		IUnit u = UnitManager.UM().getUnit(cuc);
		String s = u.getGrade(f, g, h);
		cgUI.setChangeBtnEnable(true);
		cgUI.setMarkFieldsEditable(false);
		if (changed) {
			cgUI.setSaveBtnEnable(true);
		}
		return s;
	}

	public void enableChangeMarks() {
		cgUI.setChangeBtnEnable(false);
		cgUI.setSaveBtnEnable(false);
		cgUI.setMarkFieldsEditable(true);
		changed = true;
	}

	public void saveGrade(float asg1, float asg2, float exam) {

		IUnit u = UnitManager.UM().getUnit(cuc);
		IStudent s = StudentManager.get().getStudent(currentStudentID);

		IStudentUnitRecord r = s.getUnitRecord(cuc);
		r.setAsg1(asg1);
		r.setAsg2(asg2);
		r.setExam(exam);
		StudentUnitRecordManager.instance().saveRecord(r);
		cgUI.setChangeBtnEnable(true);
		cgUI.setMarkFieldsEditable(false);

	}
}
