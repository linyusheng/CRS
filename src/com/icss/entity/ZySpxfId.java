package com.icss.entity;

/**
 * ZySpxfId entity. @author MyEclipse Persistence Tools
 */

public class ZySpxfId implements java.io.Serializable {

	// Fields

	private Integer fid;
	private String fspid;
	private String fspname;
	private String fdw;
	private Float fjg;
	private String ftc;
	private String fsptype;
	private Float fcb;
	private String fcpb;
	private String fprint;
	private Float ftcjg;
	private String fbd;
	private String fhysk;
	private Float fcbjg;
	private String fxgdj;
	private String fmd;

	// Constructors

	/** default constructor */
	public ZySpxfId() {
	}

	/** full constructor */
	public ZySpxfId(Integer fid, String fspid, String fspname, String fdw,
			Float fjg, String ftc, String fsptype, Float fcb, String fcpb,
			String fprint, Float ftcjg, String fbd, String fhysk, Float fcbjg,
			String fxgdj, String fmd) {
		this.fid = fid;
		this.fspid = fspid;
		this.fspname = fspname;
		this.fdw = fdw;
		this.fjg = fjg;
		this.ftc = ftc;
		this.fsptype = fsptype;
		this.fcb = fcb;
		this.fcpb = fcpb;
		this.fprint = fprint;
		this.ftcjg = ftcjg;
		this.fbd = fbd;
		this.fhysk = fhysk;
		this.fcbjg = fcbjg;
		this.fxgdj = fxgdj;
		this.fmd = fmd;
	}

	// Property accessors

	public Integer getFid() {
		return this.fid;
	}

	public void setFid(Integer fid) {
		this.fid = fid;
	}

	public String getFspid() {
		return this.fspid;
	}

	public void setFspid(String fspid) {
		this.fspid = fspid;
	}

	public String getFspname() {
		return this.fspname;
	}

	public void setFspname(String fspname) {
		this.fspname = fspname;
	}

	public String getFdw() {
		return this.fdw;
	}

	public void setFdw(String fdw) {
		this.fdw = fdw;
	}

	public Float getFjg() {
		return this.fjg;
	}

	public void setFjg(Float fjg) {
		this.fjg = fjg;
	}

	public String getFtc() {
		return this.ftc;
	}

	public void setFtc(String ftc) {
		this.ftc = ftc;
	}

	public String getFsptype() {
		return this.fsptype;
	}

	public void setFsptype(String fsptype) {
		this.fsptype = fsptype;
	}

	public Float getFcb() {
		return this.fcb;
	}

	public void setFcb(Float fcb) {
		this.fcb = fcb;
	}

	public String getFcpb() {
		return this.fcpb;
	}

	public void setFcpb(String fcpb) {
		this.fcpb = fcpb;
	}

	public String getFprint() {
		return this.fprint;
	}

	public void setFprint(String fprint) {
		this.fprint = fprint;
	}

	public Float getFtcjg() {
		return this.ftcjg;
	}

	public void setFtcjg(Float ftcjg) {
		this.ftcjg = ftcjg;
	}

	public String getFbd() {
		return this.fbd;
	}

	public void setFbd(String fbd) {
		this.fbd = fbd;
	}

	public String getFhysk() {
		return this.fhysk;
	}

	public void setFhysk(String fhysk) {
		this.fhysk = fhysk;
	}

	public Float getFcbjg() {
		return this.fcbjg;
	}

	public void setFcbjg(Float fcbjg) {
		this.fcbjg = fcbjg;
	}

	public String getFxgdj() {
		return this.fxgdj;
	}

	public void setFxgdj(String fxgdj) {
		this.fxgdj = fxgdj;
	}

	public String getFmd() {
		return this.fmd;
	}

	public void setFmd(String fmd) {
		this.fmd = fmd;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof ZySpxfId))
			return false;
		ZySpxfId castOther = (ZySpxfId) other;

		return ((this.getFid() == castOther.getFid()) || (this.getFid() != null
				&& castOther.getFid() != null && this.getFid().equals(
				castOther.getFid())))
				&& ((this.getFspid() == castOther.getFspid()) || (this
						.getFspid() != null && castOther.getFspid() != null && this
						.getFspid().equals(castOther.getFspid())))
				&& ((this.getFspname() == castOther.getFspname()) || (this
						.getFspname() != null && castOther.getFspname() != null && this
						.getFspname().equals(castOther.getFspname())))
				&& ((this.getFdw() == castOther.getFdw()) || (this.getFdw() != null
						&& castOther.getFdw() != null && this.getFdw().equals(
						castOther.getFdw())))
				&& ((this.getFjg() == castOther.getFjg()) || (this.getFjg() != null
						&& castOther.getFjg() != null && this.getFjg().equals(
						castOther.getFjg())))
				&& ((this.getFtc() == castOther.getFtc()) || (this.getFtc() != null
						&& castOther.getFtc() != null && this.getFtc().equals(
						castOther.getFtc())))
				&& ((this.getFsptype() == castOther.getFsptype()) || (this
						.getFsptype() != null && castOther.getFsptype() != null && this
						.getFsptype().equals(castOther.getFsptype())))
				&& ((this.getFcb() == castOther.getFcb()) || (this.getFcb() != null
						&& castOther.getFcb() != null && this.getFcb().equals(
						castOther.getFcb())))
				&& ((this.getFcpb() == castOther.getFcpb()) || (this.getFcpb() != null
						&& castOther.getFcpb() != null && this.getFcpb()
						.equals(castOther.getFcpb())))
				&& ((this.getFprint() == castOther.getFprint()) || (this
						.getFprint() != null && castOther.getFprint() != null && this
						.getFprint().equals(castOther.getFprint())))
				&& ((this.getFtcjg() == castOther.getFtcjg()) || (this
						.getFtcjg() != null && castOther.getFtcjg() != null && this
						.getFtcjg().equals(castOther.getFtcjg())))
				&& ((this.getFbd() == castOther.getFbd()) || (this.getFbd() != null
						&& castOther.getFbd() != null && this.getFbd().equals(
						castOther.getFbd())))
				&& ((this.getFhysk() == castOther.getFhysk()) || (this
						.getFhysk() != null && castOther.getFhysk() != null && this
						.getFhysk().equals(castOther.getFhysk())))
				&& ((this.getFcbjg() == castOther.getFcbjg()) || (this
						.getFcbjg() != null && castOther.getFcbjg() != null && this
						.getFcbjg().equals(castOther.getFcbjg())))
				&& ((this.getFxgdj() == castOther.getFxgdj()) || (this
						.getFxgdj() != null && castOther.getFxgdj() != null && this
						.getFxgdj().equals(castOther.getFxgdj())))
				&& ((this.getFmd() == castOther.getFmd()) || (this.getFmd() != null
						&& castOther.getFmd() != null && this.getFmd().equals(
						castOther.getFmd())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getFid() == null ? 0 : this.getFid().hashCode());
		result = 37 * result
				+ (getFspid() == null ? 0 : this.getFspid().hashCode());
		result = 37 * result
				+ (getFspname() == null ? 0 : this.getFspname().hashCode());
		result = 37 * result
				+ (getFdw() == null ? 0 : this.getFdw().hashCode());
		result = 37 * result
				+ (getFjg() == null ? 0 : this.getFjg().hashCode());
		result = 37 * result
				+ (getFtc() == null ? 0 : this.getFtc().hashCode());
		result = 37 * result
				+ (getFsptype() == null ? 0 : this.getFsptype().hashCode());
		result = 37 * result
				+ (getFcb() == null ? 0 : this.getFcb().hashCode());
		result = 37 * result
				+ (getFcpb() == null ? 0 : this.getFcpb().hashCode());
		result = 37 * result
				+ (getFprint() == null ? 0 : this.getFprint().hashCode());
		result = 37 * result
				+ (getFtcjg() == null ? 0 : this.getFtcjg().hashCode());
		result = 37 * result
				+ (getFbd() == null ? 0 : this.getFbd().hashCode());
		result = 37 * result
				+ (getFhysk() == null ? 0 : this.getFhysk().hashCode());
		result = 37 * result
				+ (getFcbjg() == null ? 0 : this.getFcbjg().hashCode());
		result = 37 * result
				+ (getFxgdj() == null ? 0 : this.getFxgdj().hashCode());
		result = 37 * result
				+ (getFmd() == null ? 0 : this.getFmd().hashCode());
		return result;
	}

}