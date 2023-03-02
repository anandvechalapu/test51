
Controller

@RestController
@RequestMapping("/configuration")
public class ConfigurationController {

    private final ConfigurationService configurationService;

    public ConfigurationController(ConfigurationService configurationService) {
        this.configurationService = configurationService;
    }

    @PostMapping("/jira-github")
    public ResponseEntity<Void> configureJiraGithub(@RequestBody JiraGithubConfiguration jiraGithubConfiguration) {
        configurationService.configureJiraGithub(jiraGithubConfiguration);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}

Service

@Service
public class ConfigurationService {

    private final ConfigurationRepository configurationRepository;

    public ConfigurationService(ConfigurationRepository configurationRepository) {
        this.configurationRepository = configurationRepository;
    }

    public void configureJiraGithub(JiraGithubConfiguration jiraGithubConfiguration) {
        configurationRepository.save(jiraGithubConfiguration);
    }
}

Repository

@Repository
public interface ConfigurationRepository extends JpaRepository<JiraGithubConfiguration, Long> {
}