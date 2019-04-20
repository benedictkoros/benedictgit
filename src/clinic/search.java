/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clinic;

/**
 *
 * @author Benedict
 */
class search {
     private String  admno ,firstname,lastname,gender,dob,sno,prefhosp,nokname,nokno;
    
    public search (String AdmNo,String FistName,String LastName,String Gender, String Dateofbirth,String Studentcontact,String Prefhosp,String Nokname,String Nokno){
        //this.id=Id;
        this.admno=AdmNo;
        this.firstname=FistName;
        this.lastname=LastName;
       
        this.gender=Gender;
        this.dob=Dateofbirth;
        this.sno=Studentcontact;
        this.prefhosp=Prefhosp;
        this.nokname=Nokname;
        this.nokno=Nokno;
        
    }


    public String getAdmno(){
        return admno;
    }
    public void setAdno(String AdmNo){
        this.admno= AdmNo;
        
    }
    public String getFirtsname(){
        return firstname ;
    }
     public void setFirstname(String FirstName){
        this.firstname=FirstName;
        
    }
    public String getLastname(){
        return lastname;
    }
     public void setLastnam(String LastName){
        this.lastname=LastName;
}
     
public String getGender(){
        return gender;
    }
     public void setGender(String Gender){
        this.gender=Gender;
}     
public String getDOB(){
        return dob;
    }
     public void setDOB(String DOB){
        this.dob=DOB;
}  
     public String getSNO(){
        return sno;
    }
     public void setSNO(String Sno){
        this.sno=Sno;
}
      public String getPREFHOSP(){
        return prefhosp;
    }
     public void setPREFHOSP(String Prefhosp){
        this.prefhosp=Prefhosp;
}
      public String getNOKNAME(){
        return nokname;
    }
     public void setNOKNAME(String Nokname){
        this.nokname=Nokname;
}
     public String getNOKNO(){
        return nokno;
    }
     public void setNOKNO(String Nokno){
        this.nokno=Nokno;
}
}
