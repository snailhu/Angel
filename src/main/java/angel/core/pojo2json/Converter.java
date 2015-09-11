package angel.core.pojo2json;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.data.domain.Page;

import angel.core.dto.DPage;


public interface Converter<Domain,DTO> {

	 public DTO convert(Domain domain);
	 
	 public List<DTO> convert(List<Domain> domainList);
	 
	 public List<DTO> convert(Set<Domain> domainSet);
	 
	 public DPage<DTO> convert(Page<Domain> domainPage);
	 
	 public Map<String, List<DTO>> convert(Map<String, List<Domain>> map);
}
