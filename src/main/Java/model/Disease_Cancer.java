package model;

public class Disease_Cancer {
    private Long no;

    private String cancer;

    private String gene;

    private String antigen;

    private String nucleicAcidExchange;

    private String aminoAcidExchange;

    private String hlaAllele;

    private Long length;

    private String peptide;

    private String adjuvant;

    private String journalRef;

    private Long pmid;

    public Disease_Cancer(Long no, String cancer, String gene, String antigen, String nucleicAcidExchange, String aminoAcidExchange, String hlaAllele, Long length, String peptide, String adjuvant, String journalRef, Long pmid) {
        this.no = no;
        this.cancer = cancer;
        this.gene = gene;
        this.antigen = antigen;
        this.nucleicAcidExchange = nucleicAcidExchange;
        this.aminoAcidExchange = aminoAcidExchange;
        this.hlaAllele = hlaAllele;
        this.length = length;
        this.peptide = peptide;
        this.adjuvant = adjuvant;
        this.journalRef = journalRef;
        this.pmid = pmid;
    }

    public Disease_Cancer() {
        super();
    }

    public Long getNo() {
        return no;
    }

    public void setNo(Long no) {
        this.no = no;
    }

    public String getCancer() {
        return cancer;
    }

    public void setCancer(String cancer) {
        this.cancer = cancer == null ? null : cancer.trim();
    }

    public String getGene() {
        return gene;
    }

    public void setGene(String gene) {
        this.gene = gene == null ? null : gene.trim();
    }

    public String getAntigen() {
        return antigen;
    }

    public void setAntigen(String antigen) {
        this.antigen = antigen == null ? null : antigen.trim();
    }

    public String getNucleicAcidExchange() {
        return nucleicAcidExchange;
    }

    public void setNucleicAcidExchange(String nucleicAcidExchange) {
        this.nucleicAcidExchange = nucleicAcidExchange == null ? null : nucleicAcidExchange.trim();
    }

    public String getAminoAcidExchange() {
        return aminoAcidExchange;
    }

    public void setAminoAcidExchange(String aminoAcidExchange) {
        this.aminoAcidExchange = aminoAcidExchange == null ? null : aminoAcidExchange.trim();
    }

    public String getHlaAllele() {
        return hlaAllele;
    }

    public void setHlaAllele(String hlaAllele) {
        this.hlaAllele = hlaAllele == null ? null : hlaAllele.trim();
    }

    public Long getLength() {
        return length;
    }

    public void setLength(Long length) {
        this.length = length;
    }

    public String getPeptide() {
        return peptide;
    }

    public void setPeptide(String peptide) {
        this.peptide = peptide == null ? null : peptide.trim();
    }

    public String getAdjuvant() {
        return adjuvant;
    }

    public void setAdjuvant(String adjuvant) {
        this.adjuvant = adjuvant == null ? null : adjuvant.trim();
    }

    public String getJournalRef() {
        return journalRef;
    }

    public void setJournalRef(String journalRef) {
        this.journalRef = journalRef == null ? null : journalRef.trim();
    }

    public Long getPmid() {
        return pmid;
    }

    public void setPmid(Long pmid) {
        this.pmid = pmid;
    }
}