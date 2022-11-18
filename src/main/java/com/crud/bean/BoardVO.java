package com.crud.bean;

import java.util.Date;

public class BoardVO {
	private int seq;
	private String NAME;
	private String team;
	private int goal;
	private int assist;
	private int point;
	private String photo;
	private Date regdate;

	private int shoot;
	private int play;
	private String position;

	public int getPlay() {
		return play;
	}

	public void setShoot(int shoot) {
		this.shoot = shoot;
	}

	public int getShoot(){
		return shoot;
	}
	public void setPlay(int play) {
		this.play = play;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public int getSeq(){return seq;}
	public void setSeq(int seq){ this.seq=seq; }
	
	public String getNAME() {
		return NAME;
	}
	public void setNAME(String NAME) {
		this.NAME = NAME;
	}
	public String getTeam() { return team; }
	public void setTeam(String team) { this.team=team; }
	public int getGoal() {
		return goal;
	}
	public void setGoal(int goal) {
		this.goal = goal;
	}
	public int getAssist() {
		return assist;
	}
	public void setAssist(int assist) {
		this.assist = assist;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}

	public Date getRegdate() {
		return regdate;
	}
	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public String getPhoto(){return photo;}
	public void setPhoto(String photo) {this.photo=photo;}

}
