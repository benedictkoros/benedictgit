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
class medical {
     private String  admno ,firstname,lastname,labtest,comments,date,drugs,disease;
    
    public medical (String AdmNo,String FistName,String LastName,String LabTest,String Comments,String Disease,String Date,String Drugs){
        //this.id=Id;
        this.admno=AdmNo;
        this.firstname=FistName;
        this.lastname=LastName;
        this.labtest=LabTest;
        this.comments=Comments;
        this.drugs=Drugs;
        this.date=Date;
        this.disease=Disease;
        
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
     
public String getLabtest(){
        return labtest;
    }
     public void setLabtest(String LabTest){
        this.labtest=LabTest;
}     
public String getComments(){
        return comments;
    }
     public void setComments(String Commments){
        this.comments=Commments;
}  
     public String getDrugs(){
        return drugs;
    }
     public void setDrugs(String Drugs){
        this.drugs=Drugs;
}
      public String getDate(){
        return date;
    }
     public void setDate(String Date){
        this.date=Date;
}
     public String getDisease(){
        return disease;
    }
     public void setDisease(String Disease){
        this.disease=Disease;
}
}
