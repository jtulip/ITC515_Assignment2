package datamanagement;
public class StudentUnitRecord implements IStudentUnitRecord 
{
private Integer studentID;
private String unitCode;
private float asg1;
private float asg2;
private float exam;
public StudentUnitRecord( Integer id, String code, float asg1, float asg2, float exam ) 
{
this.studentID = id;
        this.unitCode = code;
    this.asg1 = asg1;
    
    
    
    
                this.asg2 = asg2;
    this.exam = exam;}
    public Integer getStudentID() { 
    return studentID; 
}
    
public String getUnitCode() { 
        return unitCode;}

        public void setAsg1(float mark) { 
            this.asg1 = mark;}
            public float getAsg1() { 
                
    return this.asg1; 
}

public void setAsg2(float mark) { this.asg2 = mark; 




}
    
    public float getAsg2() { 
        return this.asg2;}
        public void setExam(float mark) { 
        this.exam = mark;}
        public float getExam() { 
return this.exam; }
public float getTotal() { 
        return asg1 + asg2 + exam; 

        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
                                                                                    }}
