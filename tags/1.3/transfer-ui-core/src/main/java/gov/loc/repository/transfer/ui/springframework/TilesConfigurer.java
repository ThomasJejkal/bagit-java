package gov.loc.repository.transfer.ui.springframework;

import java.io.File;
import java.util.ArrayList;

import org.apache.struts.tiles.DefinitionsFactoryException;
import org.springframework.util.PatternMatchUtils;

public class TilesConfigurer extends
org.springframework.web.servlet.view.tiles.TilesConfigurer {
	private String pattern = "*.*";
	private String definitionPath = "/WEB-INF";
	
	public void setDefinitionPattern(String pattern)
	{
		this.pattern = pattern;
	}
	
	public void setDefinitionPath(String definitionPath)
	{
		this.definitionPath = definitionPath;
	}
		
	@Override
	public void afterPropertiesSet() throws DefinitionsFactoryException {
		File contextDir = new File(this.getServletContext().getRealPath("."));
		
		ArrayList<String> definitionList = new ArrayList<String>();
		File definitionDir = new File(contextDir, this.definitionPath);
		for(File file : definitionDir.listFiles())
		{
			if (PatternMatchUtils.simpleMatch(this.pattern, file.getName()))
			{
				String definition = this.definitionPath;
				if (! this.definitionPath.endsWith("/"))
				{
					definition += "/";
				}
				definition += file.getName();
				this.logger.debug("Discovered tiles definition: " + definition);
				definitionList.add(definition);
			}
			
		}
		this.setDefinitions(definitionList.toArray(new String[0]));
		
		super.afterPropertiesSet();
	}
}
