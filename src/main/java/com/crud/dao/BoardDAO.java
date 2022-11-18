package com.crud.dao;

import com.crud.bean.BoardVO;
import com.crud.common.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class  BoardDAO {

	static Connection conn = null;
	static PreparedStatement stmt = null;
	static ResultSet rs = null;

	private final String BOARD_INSERT = "insert into BOARD (photo, NAME, team, goal, assist, total_point, shoot, play, position) values (?,?,?,?,?,?,?,?,?)";
	private final String BOARD_UPDATE = "update BOARD set photo=?, NAME=?, team=?, goal=?, assist=?, total_point=?, shoot=?, play=?, position=? where seq=?";
	private final String BOARD_DELETE = "delete from BOARD  where seq=?";
	private final String BOARD_GET = "select * from BOARD  where seq=?";
	private final String BOARD_LIST = "select * from BOARD order by seq desc";
	private static final String BOARD_SELECT = "select*from BOARD where seq=?";
	public int insertBoard(BoardVO vo) {
		System.out.println("===> JDBC로 insertBoard() 기능 처리");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_INSERT);
			stmt.setString(1,vo.getPhoto());
			stmt.setString(2, vo.getNAME());
			stmt.setString(3, vo.getTeam());
			stmt.setInt(4, vo.getGoal());
			stmt.setInt(5, vo.getAssist());
			stmt.setInt(6,vo.getPoint());
			stmt.setInt(7,vo.getShoot());
			stmt.setInt(8,vo.getPlay());
			stmt.setString(9,vo.getPosition());
			stmt.executeUpdate();
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	// 글 삭제
	public void deleteBoard(BoardVO vo) {
		System.out.println("===> JDBC로 deleteBoard() 기능 처리");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_DELETE);
			stmt.setInt(1, vo.getSeq());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public int updateBoard(BoardVO vo) {
		System.out.println("===> JDBC로 updateBoard() 기능 처리");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_UPDATE);
			stmt.setString(1, vo.getPhoto());
			stmt.setString(2, vo.getNAME());
			stmt.setString(3, vo.getTeam());
			stmt.setInt(4, vo.getGoal());
			stmt.setInt(5, vo.getAssist());
			stmt.setInt(6, vo.getPoint());
			stmt.setInt(7,vo.getShoot());
			stmt.setInt(8,vo.getPlay());
			stmt.setString(9,vo.getPosition());
			stmt.setInt(10, vo.getSeq());


			System.out.println(vo.getPhoto() + "-" +vo.getNAME()+ "-" + vo.getTeam() + "-" + vo.getGoal() + "-" + vo.getAssist() + "-" + vo.getPoint() + "-" + vo.getSeq());
			stmt.executeUpdate();
			return 1;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}	
	
	public BoardVO getBoard(int seq) {
		BoardVO one = new BoardVO();
		System.out.println("===> JDBC로 getBoard() 기능 처리");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_GET);
			stmt.setInt(1, seq);
			rs = stmt.executeQuery();
			if(rs.next()) {
				one.setSeq(rs.getInt("seq"));
				one.setPhoto(rs.getString("photo"));
				one.setNAME(rs.getString("NAME"));
				one.setTeam(rs.getString("team"));
				one.setGoal(rs.getInt("goal"));
				one.setAssist(rs.getInt("assist"));
				one.setPoint(rs.getInt("total_point"));
				one.setShoot(rs.getInt("shoot"));
				one.setPlay(rs.getInt("play"));
				one.setPosition(rs.getString("position"));

			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return one;
	}
	
	public List<BoardVO> getBoardList(){
		List<BoardVO> list = new ArrayList<BoardVO>();
		System.out.println("===> JDBC로 getBoardList() 기능 처리");
		try {
			conn = JDBCUtil.getConnection();
			stmt = conn.prepareStatement(BOARD_LIST);
			rs = stmt.executeQuery();
			while(rs.next()) {
				BoardVO one = new BoardVO();
				one.setSeq(rs.getInt("seq"));
				one.setPhoto(rs.getString("photo"));
				one.setNAME(rs.getString("NAME"));
				one.setTeam(rs.getString("team"));
				one.setGoal(rs.getInt("goal"));
				one.setAssist(rs.getInt("assist"));
				one.setRegdate(rs.getDate("regdate"));
				one.setPoint(rs.getInt("total_point"));
				one.setShoot(rs.getInt("shoot"));
				one.setPlay(rs.getInt("play"));
				one.setPosition(rs.getString("position"));
				list.add(one);
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return list;
	}

	public static String getPhotoFilename(int seq){
		String filename=null;
		try {
			conn=JDBCUtil.getConnection();
			stmt=conn.prepareStatement(BOARD_SELECT);
			stmt.setInt(1,seq);
			rs=stmt.executeQuery();
			if(rs.next()){
				filename=rs.getString("photo");
			}
			rs.close();
		}catch (Exception e){
			e.printStackTrace();
		}
		System.out.println("===> JDBC로 getPhotoFilename() 기능 처리");
		return filename;
	}
}
