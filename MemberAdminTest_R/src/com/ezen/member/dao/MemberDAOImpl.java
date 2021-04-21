package com.ezen.member.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.ezen.member.dto.MemberVO;

public class MemberDAOImpl implements MemberDAO {
/* JdbcTemplate 사용 블로그
 * https://gmlwjd9405.github.io/2018/12/19/jdbctemplate-usage.html
 * */
	private JdbcTemplate jdbcTemplate;

	/*DataSource를 주입*/
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List selectAllMembers() throws DataAccessException {
		// TODO Auto-generated method stub
		System.out.println("listMembers.jsp :MemberDAOImpl->selectAllMembers()");
		String query="select * from memberInfo order by joindate desc";
		
		List<MemberVO> memberList=new ArrayList<MemberVO>();
		
		//query() : 복수의 객체를 가져올 때 사용
		memberList=this.jdbcTemplate.query(query, new RowMapper<MemberVO>() {
			public MemberVO mapRow(ResultSet rs, int rowNum) throws SQLException{
				/*보통 이렇게 사용(외워)*/
				MemberVO memberVO=new MemberVO();
				//객체 담기
				memberVO.setMemberId(rs.getString("memberid"));
				memberVO.setMemberPw(rs.getString("memberpw"));
				memberVO.setMemberName(rs.getString("membername"));
				memberVO.setGender(rs.getString("gender"));
				memberVO.setMemberEmail(rs.getString("memberemail"));
				memberVO.setJoinDate(rs.getDate("joindate"));
				return memberVO;
			}
		});
		//add를 하지 않아도 알아서 List에 삽입(while문 대신 jdbcTemplate을 사용하는 이유)
		return memberList;
	}

	@Override
	public MemberVO selectMember(String memberid) throws DataAccessException {
		// TODO Auto-generated method stub
		//listMembers.jsp에서 해당이름을 클릭할 경우 회원 정보페이지로 이동
		System.out.println("memberDetail.jsp :MemberDAOImpl->selectMember("+memberid+")");
		String query="select * from memberInfo where memberid=?";
		
		//queryForObject() : 하나의 객체를 가져올 때 사용
		MemberVO member = this.jdbcTemplate.queryForObject(query, 
				new Object[] { memberid}, new RowMapper<MemberVO>() { 
			public MemberVO mapRow(ResultSet rs, int rowNum) throws SQLException{
				MemberVO memberVO=new MemberVO();
				memberVO.setMemberId(rs.getString("memberid"));
				memberVO.setMemberPw(rs.getString("memberpw"));
				memberVO.setMemberName(rs.getString("membername"));
				memberVO.setGender(rs.getString("gender"));
				memberVO.setMemberEmail(rs.getString("memberemail"));
				memberVO.setJoinDate(rs.getDate("joindate"));
				return memberVO;
			}
		});
		return member;
	}

	@Override
	public void insertMember(MemberVO member) throws DataAccessException {
		// TODO Auto-generated method stub
		System.out.println("memberForm.jsp :MemberDAOImpl->insertMember()");
		String query = "insert into memberInfo(memberid, memberpw, membername, gender, " 
				+ "memberemail) values(?,?,?,?,?)";
		this.jdbcTemplate.update(query, new Object[] { 
				/* DB에 값 넣기 */
				member.getMemberId(), member.getMemberPw(), member.getMemberName(),
				member.getGender(), member.getMemberEmail()
		});
	}

	@Override
	public void updateMember(MemberVO member) throws DataAccessException {
		// TODO Auto-generated method stub
		System.out.println("memberForm.jsp :MemberDAOImpl->updateMember()");
		String query = "update memberInfo set memberid=?, memberpw=?, " 
				+"membername=?, gender=?, memberemail=? where memberid=?";
		this.jdbcTemplate.update(query, new Object[] {
				member.getMemberId(), member.getMemberPw(), member.getMemberName(),
				member.getGender(), member.getMemberEmail(), member.getMemberId()
		});
	}

	@Override
	public void deleteMember(String memberid) throws DataAccessException {
		// TODO Auto-generated method stub
		System.out.println("memberDetail.jsp :MemberDAOImpl->deleteMember("+memberid+")");
		String query = "delete from memberInfo where memberid=?";
		
		this.jdbcTemplate.update(query, new Object[] {memberid});
	}

}
