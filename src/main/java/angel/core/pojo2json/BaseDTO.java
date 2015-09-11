package angel.core.pojo2json;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.data.domain.Page;

import angel.core.dto.DPage;


public abstract class BaseDTO<Domain,DTO> implements Converter<Domain, DTO> {

	@Override
	public abstract DTO convert(Domain domain);

	@Override
	public List<DTO> convert(Set<Domain> domainSet) {
		if(domainSet !=null){
			List<DTO> dtos = new ArrayList<DTO>();
			for (Domain domain : domainSet) {
				dtos.add(this.convert(domain));}
			return dtos;
			}
		return null;
	}

	@Override
	public Map<String, List<DTO>> convert(Map<String, List<Domain>> map) {
		if(map==null)
			return null;
		Map<String, List<DTO>> map2 = new HashMap<String, List<DTO>>();
		for (String str : map.keySet()) {
			map2.put(str, this.convert(map.get(str)));
		}
		return map2;
	}

	
	@Override
	public List<DTO> convert(List<Domain> domainList) {
		if(domainList !=null){
			List<DTO> dtos = new ArrayList<DTO>();
			for (Domain domain : domainList) {
				dtos.add(this.convert(domain));}
			return dtos;
			}
		return null;
	}

	@Override
	public DPage<DTO> convert(Page<Domain> domainPage) {
		if(domainPage==null){return null;}
		else{
			DPage<DTO> dPage = new DPage<DTO>();
			dPage.setTotalElements(domainPage.getTotalElements());
			dPage.setTotalPages(domainPage.getTotalPages());
			dPage.setData(this.convert(domainPage.getContent()));
			return dPage;
		}
		
	}

}
