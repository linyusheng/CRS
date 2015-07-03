package com.icss.entity;

/**
 * ZySpId entity. @author MyEclipse Persistence Tools
 */

public class ZySpId implements java.io.Serializable {

	// Fields

	private Integer fid;
	private String fspid;
	private String fspname;
	private Float fjg;
	private String fdw;
	private String ftc;
	private String fsptype;
	private Integer ftimelong;
	private String ffjfw;
	private Integer fjztimelong;
	private Float fjzjg;
	private Float ftcjg;
	private Float fcbjg;
	private String fjrlz;
	private String fxgdj;
	private String fpic;
	private String fnote;
	private String fmd;

	// Constructors

	/** default constructor */
	public ZySpId() {
	}

	/** full constructor */
	public ZySpId(Integer fid, String fspid, String fspname, Float fjg,
			String fdw, String ftc, String fsptype, Integer ftimelong,
			String ffjfw, Integer fjztimelong, Float fjzjg, Float ftcjg,
			Float fcbjg, String fjrlz, String fxgdj, String fpic, String fnote,
			String fmd) {
		this.fid = fid;
		this.fspid = fspid;
		this.fspname = fspname;
		this.fjg = fjg;
		this.fdw = fdw;
		this.ftc = ftc;
		this.fsptype = fsptype;
		this.ftimelong = ftimelong;
		this.ffjfw = ffjfw;
		this.fjztimelong = fjztimelong;
		this.fjzjg = fjzjg;
		this.ftcjg = ftcjg;
		this.fcbjg = fcbjg;
		this.fjrlz = fjrlz;
		this.fxgdj = fxgdj;
		this.fpic = fpic;
		this.fnote = fnote;
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

	public Float getFjg() {
		return this.fjg;
	}

	public void setFjg(Float fjg) {
		this.fjg = fjg;
	}

	public String getFdw() {
		return this.fdw;
	}

	public void setFdw(String fdw) {
		this.fdw = fdw;
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

	public Integer getFtimelong() {
		return this.ftimelong;
	}

	public void setFtimelong(Integer ftimelong) {
		this.ftimelong = ftimelong;
	}

	public String getFfjfw() {
		return this.ffjfw;
	}

	public void setFfjfw(String ffjfw) {
		this.ffjfw = ffjfw;
	}

	public Integer getFjztimelong() {
		return this.fjztimelong;
	}

	public void setFjztimelong(Integer fjztimelong) {
		this.fjztimelong = fjztimelong;
	}

	public Float getFjzjg() {
		return this.fjzjg;
	}

	public void setFjzjg(Float fjzjg) {
		this.fjzjg = fjzjg;
	}

	public Float getFtcjg() {
		return this.ftcjg;
	}

	public void setFtcjg(Float ftcjg) {
		this.ftcjg = ftcjg;
	}

	public Float getFcbjg() {
		return this.fcbjg;
	}

	public void setFcbjg(Float fcbjg) {
		this.fcbjg = fcbjg;
	}

	public String getFjrlz() {
		return this.fjrlz;
	}

	public void setFjrlz(String fjrlz) {
		this.fjrlz = fjrlz;
	}

	public String getFxgdj() {
		return this.fxgdj;
	}

	public void setFxgdj(String fxgdj) {
		this.fxgdj = fxgdj;
	}

	public String getFpic() {
		return this.fpic;
	}

	public void setFpic(String fpic) {
		this.fpic = fpic;
	}

	public String getFnote() {
		return this.fnote;
	}

	public void setFnote(String fnote) {
		this.fnote = fnote;
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
		if (!(other instanceof ZySpId))
			return false;
		ZySpId castOther = (ZySpId) other;

		return ((this.getFid() == castOther.getFid()) || (this.getFid() != null
				&& castOther.getFid() != null && this.getFid().equals(
				castOther.getFid())))
				&& ((this.getFspid() == castOther.getFspid()) || (this
						.getFspid() != null && castOther.getFspid() != null && this
						.getFspid().equals(castOther.getFspid())))
				&& ((this.getFspname() == castOther.getFspname()) || (this
						.getFspname() != null && castOther.getFspname() != null && this
						.getFspname().equals(castOther.getFspname())))
				&& ((this.getFjg() == castOther.getFjg()) || (this.getFjg() != null
						&& castOther.getFjg() != null && this.getFjg().equals(
						castOther.getFjg())))
				&& ((this.getFdw() == castOther.getFdw()) || (this.getFdw() != null
						&& castOther.getFdw() != null && this.getFdw().equals(
						castOther.getFdw())))
				&& ((this.getFtc() == castOther.getFtc()) || (this.getFtc() != null
						&& castOther.getFtc() != null && this.getFtc().equals(
						castOther.getFtc())))
				&& ((this.getFsptype() == castOther.getFsptype()) || (this
						.getFsptype() != null && castOther.getFsptype() != null && this
						.getFsptype().equals(castOther.getFsptype())))
				&& ((this.getFtimelong() == castOther.getFtimelong()) || (this
						.getFtimelong() != null
						&& castOther.getFtimelong() != null && this
						.getFtimelong().equals(castOther.getFtimelong())))
				&& ((this.getFfjfw() == castOther.getFfjfw()) || (this
						.getFfjfw() != null && castOther.getFfjfw() != null && this
						.getFfjfw().equals(castOther.getFfjfw())))
				&& ((this.getFjztimelong() == castOther.getFjztimelong()) || (this
						.getFjztimelong() != null
						&& castOther.getFjztimelong() != null && this
						.getFjztimelong().equals(castOther.getFjztimelong())))
				&& ((this.getFjzjg() == castOther.getFjzjg()) || (this
						.getFjzjg() != null && castOther.getFjzjg() != null && this
						.getFjzjg().equals(castOther.getFjzjg())))
				&& ((this.getFtcjg() == castOther.getFtcjg()) || (this
						.getFtcjg() != null && castOther.getFtcjg() != null && this
						.getFtcjg().equals(castOther.getFtcjg())))
				&& ((this.getFcbjg() == castOther.getFcbjg()) || (this
						.getFcbjg() != null && castOther.getFcbjg() != null && this
						.getFcbjg().equals(castOther.getFcbjg())))
				&& ((this.getFjrlz() == castOther.getFjrlz()) || (this
						.getFjrlz() != null && castOther.getFjrlz() != null && this
						.getFjrlz().equals(castOther.getFjrlz())))
				&& ((this.getFxgdj() == castOther.getFxgdj()) || (this
						.getFxgdj() != null && castOther.getFxgdj() != null && this
						.getFxgdj().equals(castOther.getFxgdj())))
				&& ((this.getFpic() == castOther.getFpic()) || (this.getFpic() != null
						&& castOther.getFpic() != null && this.getFpic()
						.equals(castOther.getFpic())))
				&& ((this.getFnote() == castOther.getFnote()) || (this
						.getFnote() != null && castOther.getFnote() != null && this
						.getFnote().equals(castOther.getFnote())))
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
				+ (getFjg() == null ? 0 : this.getFjg().hashCode());
		result = 37 * result
				+ (getFdw() == null ? 0 : this.getFdw().hashCode());
		result = 37 * result
				+ (getFtc() == null ? 0 : this.getFtc().hashCode());
		result = 37 * result
				+ (getFsptype() == null ? 0 : this.getFsptype().hashCode());
		result = 37 * result
				+ (getFtimelong() == null ? 0 : this.getFtimelong().hashCode());
		result = 37 * result
				+ (getFfjfw() == null ? 0 : this.getFfjfw().hashCode());
		result = 37
				* result
				+ (getFjztimelong() == null ? 0 : this.getFjztimelong()
						.hashCode());
		result = 37 * result
				+ (getFjzjg() == null ? 0 : this.getFjzjg().hashCode());
		result = 37 * result
				+ (getFtcjg() == null ? 0 : this.getFtcjg().hashCode());
		result = 37 * result
				+ (getFcbjg() == null ? 0 : this.getFcbjg().hashCode());
		result = 37 * result
				+ (getFjrlz() == null ? 0 : this.getFjrlz().hashCode());
		result = 37 * result
				+ (getFxgdj() == null ? 0 : this.getFxgdj().hashCode());
		result = 37 * result
				+ (getFpic() == null ? 0 : this.getFpic().hashCode());
		result = 37 * result
				+ (getFnote() == null ? 0 : this.getFnote().hashCode());
		result = 37 * result
				+ (getFmd() == null ? 0 : this.getFmd().hashCode());
		return result;
	}

}