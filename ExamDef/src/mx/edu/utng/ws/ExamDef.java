package mx.edu.utng.ws;

public class ExamDef {
	private int id;
	private String name;
	private String description;
	private int mininumCorr;
	private int duration;
	private String examTake;
	private String questionDef;
	
	public ExamDef(int id, String name, String description, int mininumCorr, int duration, String examTake,
			String questionDef) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.mininumCorr = mininumCorr;
		this.duration = duration;
		this.examTake = examTake;
		this.questionDef = questionDef;
	}
	
	public ExamDef() {
		this(0,"","",0,0,"","");
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getMininumCorr() {
		return mininumCorr;
	}

	public void setMininumCorr(int mininumCorr) {
		this.mininumCorr = mininumCorr;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getExamTake() {
		return examTake;
	}

	public void setExamTake(String examTake) {
		this.examTake = examTake;
	}

	public String getQuestionDef() {
		return questionDef;
	}

	public void setQuestionDef(String questionDef) {
		this.questionDef = questionDef;
	}

	@Override
	public String toString() {
		return "ExamDef [id=" + id + ", name=" + name + ", description=" + description + ", mininumCorr=" + mininumCorr
				+ ", duration=" + duration + ", examTake=" + examTake + ", questionDef=" + questionDef + "]";
	}
	
	

}
