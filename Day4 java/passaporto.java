public class passaporto {
    private boolean byr, iyr, eyr, hgt, hcl, ecl, pid, cid;

    public passaporto(){
        this.byr = this.iyr = this.eyr = this.hgt = this.hcl = this.ecl = this.pid = this.cid = false;
    }        

    public boolean isByr() {
        return this.byr;
    }

    public boolean getByr() {
        return this.byr;
    }

    public void setByr(boolean byr) {
        this.byr = byr;
    }

    public boolean isIyr() {
        return this.iyr;
    }

    public boolean getIyr() {
        return this.iyr;
    }

    public void setIyr(boolean iyr) {
        this.iyr = iyr;
    }

    public boolean isEyr() {
        return this.eyr;
    }

    public boolean getEyr() {
        return this.eyr;
    }

    public void setEyr(boolean eyr) {
        this.eyr = eyr;
    }

    public boolean isHgt() {
        return this.hgt;
    }

    public boolean getHgt() {
        return this.hgt;
    }

    public void setHgt(boolean hgt) {
        this.hgt = hgt;
    }

    public boolean isHcl() {
        return this.hcl;
    }

    public boolean getHcl() {
        return this.hcl;
    }

    public void setHcl(boolean hcl) {
        this.hcl = hcl;
    }

    public boolean isEcl() {
        return this.ecl;
    }

    public boolean getEcl() {
        return this.ecl;
    }

    public void setEcl(boolean ecl) {
        this.ecl = ecl;
    }

    public boolean isPid() {
        return this.pid;
    }

    public boolean getPid() {
        return this.pid;
    }

    public void setPid(boolean pid) {
        this.pid = pid;
    }

    public boolean isCid() {
        return this.cid;
    }

    public boolean getCid() {
        return this.cid;
    }

    public void setCid(boolean cid) {
        this.cid = cid;
    }

    public boolean isValid(){
        if(this.byr == this.iyr == this.eyr == this.hgt == this.hcl == this.ecl == this.pid == this.cid == true){
            return true;
        }
        return false;
    }
    
}
