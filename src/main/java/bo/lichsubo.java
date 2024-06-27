package bo;

import java.util.ArrayList;

import bean.lichsubean;
import dao.lichsudao;

public class lichsubo {
	public ArrayList<lichsubean> dslichsu = new ArrayList<lichsubean>();
	lichsudao lsdao = new lichsudao();

	public ArrayList<lichsubean> getLichSu(long ma, int check) throws Exception {
		dslichsu = lsdao.getLichSu(ma, check);
		return dslichsu;
	}
}
