/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author pet
 */
@Entity
@Table(name = "treatment")
@NamedQueries({
    @NamedQuery(name = "Treatment.findAll", query = "SELECT t FROM Treatment t"),
    @NamedQuery(name = "Treatment.findById", query = "SELECT t FROM Treatment t WHERE t.id = :id"),
    @NamedQuery(name = "Treatment.findByStdId", query = "SELECT t FROM Treatment t WHERE t.stdId = :stdId"),
    @NamedQuery(name = "Treatment.findByFName", query = "SELECT t FROM Treatment t WHERE t.fName = :fName"),
    @NamedQuery(name = "Treatment.findByLName", query = "SELECT t FROM Treatment t WHERE t.lName = :lName"),
    @NamedQuery(name = "Treatment.findByGender", query = "SELECT t FROM Treatment t WHERE t.gender = :gender"),
    @NamedQuery(name = "Treatment.findBySNo", query = "SELECT t FROM Treatment t WHERE t.sNo = :sNo"),
    @NamedQuery(name = "Treatment.findByGName", query = "SELECT t FROM Treatment t WHERE t.gName = :gName"),
    @NamedQuery(name = "Treatment.findByGNo", query = "SELECT t FROM Treatment t WHERE t.gNo = :gNo")})
public class Treatment implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @Column(name = "id")
    private int id;
    @Id
    @Basic(optional = false)
    @Column(name = "std_id")
    private String stdId;
    @Basic(optional = false)
    @Column(name = "f_name")
    private String fName;
    @Basic(optional = false)
    @Column(name = "l_name")
    private String lName;
    @Basic(optional = false)
    @Column(name = "gender")
    private String gender;
    @Basic(optional = false)
    @Column(name = "s_no")
    private String sNo;
    @Basic(optional = false)
    @Column(name = "g_name")
    private String gName;
    @Basic(optional = false)
    @Column(name = "g_no")
    private String gNo;

    public Treatment() {
    }

    public Treatment(String stdId) {
        this.stdId = stdId;
    }

    public Treatment(String stdId, int id, String fName, String lName, String gender, String sNo, String gName, String gNo) {
        this.stdId = stdId;
        this.id = id;
        this.fName = fName;
        this.lName = lName;
        this.gender = gender;
        this.sNo = sNo;
        this.gName = gName;
        this.gNo = gNo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        int oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    public String getStdId() {
        return stdId;
    }

    public void setStdId(String stdId) {
        String oldStdId = this.stdId;
        this.stdId = stdId;
        changeSupport.firePropertyChange("stdId", oldStdId, stdId);
    }

    public String getFName() {
        return fName;
    }

    public void setFName(String fName) {
        String oldFName = this.fName;
        this.fName = fName;
        changeSupport.firePropertyChange("FName", oldFName, fName);
    }

    public String getLName() {
        return lName;
    }

    public void setLName(String lName) {
        String oldLName = this.lName;
        this.lName = lName;
        changeSupport.firePropertyChange("LName", oldLName, lName);
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        String oldGender = this.gender;
        this.gender = gender;
        changeSupport.firePropertyChange("gender", oldGender, gender);
    }

    public String getSNo() {
        return sNo;
    }

    public void setSNo(String sNo) {
        String oldSNo = this.sNo;
        this.sNo = sNo;
        changeSupport.firePropertyChange("SNo", oldSNo, sNo);
    }

    public String getGName() {
        return gName;
    }

    public void setGName(String gName) {
        String oldGName = this.gName;
        this.gName = gName;
        changeSupport.firePropertyChange("GName", oldGName, gName);
    }

    public String getGNo() {
        return gNo;
    }

    public void setGNo(String gNo) {
        String oldGNo = this.gNo;
        this.gNo = gNo;
        changeSupport.firePropertyChange("GNo", oldGNo, gNo);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (stdId != null ? stdId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Treatment)) {
            return false;
        }
        Treatment other = (Treatment) object;
        if ((this.stdId == null && other.stdId != null) || (this.stdId != null && !this.stdId.equals(other.stdId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Treatment[ stdId=" + stdId + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
