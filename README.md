# Calidad Integración Continua

Aquí mostramos las configuraciones que se piden para la práctica 4 de Calidad del Software.

## Configuración del *job*

```xml
<?xml version='1.1' encoding='UTF-8'?>
<maven2-moduleset plugin="maven-plugin@3.4">
  <actions/>
  <description></description>
  <keepDependencies>false</keepDependencies>
  <properties>
    <com.coravy.hudson.plugins.github.GithubProjectProperty plugin="github@1.29.5">
      <projectUrl>https://github.com/EvelioM/CalidadIntegracionContinua/</projectUrl>
      <displayName></displayName>
    </com.coravy.hudson.plugins.github.GithubProjectProperty>
  </properties>
  <scm class="hudson.plugins.git.GitSCM" plugin="git@4.0.0">
    <configVersion>2</configVersion>
    <userRemoteConfigs>
      <hudson.plugins.git.UserRemoteConfig>
        <url>https://github.com/EvelioM/CalidadIntegracionContinua</url>
        <credentialsId>6092058c-d6a8-4b0f-8bad-27e58f497cf9</credentialsId>
      </hudson.plugins.git.UserRemoteConfig>
    </userRemoteConfigs>
    <branches>
      <hudson.plugins.git.BranchSpec>
        <name>*/master</name>
      </hudson.plugins.git.BranchSpec>
    </branches>
    <doGenerateSubmoduleConfigurations>false</doGenerateSubmoduleConfigurations>
    <submoduleCfg class="list"/>
    <extensions/>
  </scm>
  <canRoam>true</canRoam>
  <disabled>false</disabled>
  <blockBuildWhenDownstreamBuilding>false</blockBuildWhenDownstreamBuilding>
  <blockBuildWhenUpstreamBuilding>false</blockBuildWhenUpstreamBuilding>
  <triggers>
    <hudson.triggers.TimerTrigger>
      <spec>@hourly</spec>
    </hudson.triggers.TimerTrigger>
    <com.cloudbees.jenkins.GitHubPushTrigger plugin="github@1.29.5">
      <spec></spec>
    </com.cloudbees.jenkins.GitHubPushTrigger>
  </triggers>
  <concurrentBuild>false</concurrentBuild>
  <rootModule>
    <groupId>com.example</groupId>
    <artifactId>demo</artifactId>
  </rootModule>
  <rootPOM>demo/pom.xml</rootPOM>
  <aggregatorStyleBuild>true</aggregatorStyleBuild>
  <incrementalBuild>false</incrementalBuild>
  <ignoreUpstremChanges>false</ignoreUpstremChanges>
  <ignoreUnsuccessfulUpstreams>false</ignoreUnsuccessfulUpstreams>
  <archivingDisabled>false</archivingDisabled>
  <siteArchivingDisabled>false</siteArchivingDisabled>
  <fingerprintingDisabled>false</fingerprintingDisabled>
  <resolveDependencies>false</resolveDependencies>
  <processPlugins>false</processPlugins>
  <mavenValidationLevel>-1</mavenValidationLevel>
  <runHeadless>false</runHeadless>
  <disableTriggerDownstreamProjects>false</disableTriggerDownstreamProjects>
  <blockTriggerWhenBuilding>true</blockTriggerWhenBuilding>
  <settings class="jenkins.mvn.DefaultSettingsProvider"/>
  <globalSettings class="jenkins.mvn.DefaultGlobalSettingsProvider"/>
  <reporters/>
  <publishers>
    <org.jenkinsci.plugins.githubissues.GitHubIssueNotifier plugin="github-issues@1.2.4">
      <issueTitle></issueTitle>
      <issueBody></issueBody>
      <issueLabel></issueLabel>
      <issueRepo></issueRepo>
      <issueReopen>false</issueReopen>
      <issueAppend>false</issueAppend>
    </org.jenkinsci.plugins.githubissues.GitHubIssueNotifier>
  </publishers>
  <buildWrappers/>
  <prebuilders/>
  <postbuilders>
    <org.sonatype.nexus.ci.nxrm.NexusPublisherBuildStep plugin="nexus-jenkins-plugin@3.8.20191216-154521.a7bf2be">
      <nexusInstanceId>localNexus</nexusInstanceId>
      <nexusRepositoryId>CIMaven</nexusRepositoryId>
      <packages>
        <org.sonatype.nexus.ci.nxrm.MavenPackage>
          <coordinate>
            <groupId>com.example</groupId>
            <artifactId>demo</artifactId>
            <version>1.0</version>
            <packaging>jar</packaging>
          </coordinate>
          <assets>
            <org.sonatype.nexus.ci.nxrm.MavenAsset>
              <filePath>/var/lib/jenkins/workspace/CIMaven/demo/target/demo-0.0.1-SNAPSHOT.jar</filePath>
              <classifier></classifier>
              <extension>jar</extension>
            </org.sonatype.nexus.ci.nxrm.MavenAsset>
          </assets>
        </org.sonatype.nexus.ci.nxrm.MavenPackage>
      </packages>
    </org.sonatype.nexus.ci.nxrm.NexusPublisherBuildStep>
  </postbuilders>
  <runPostStepsIfResult>
    <name>SUCCESS</name>
    <ordinal>0</ordinal>
    <color>BLUE</color>
    <completeBuild>true</completeBuild>
  </runPostStepsIfResult>
</maven2-moduleset>
```

## Resultado de la última *build*

```
Started by user Evelio Mora
Running as SYSTEM
Building in workspace /var/lib/jenkins/workspace/CIMaven
using credential 6092058c-d6a8-4b0f-8bad-27e58f497cf9
 > git rev-parse --is-inside-work-tree # timeout=10
Fetching changes from the remote Git repository
 > git config remote.origin.url https://github.com/EvelioM/CalidadIntegracionContinua # timeout=10
Fetching upstream changes from https://github.com/EvelioM/CalidadIntegracionContinua
 > git --version # timeout=10
using GIT_ASKPASS to set credentials 
 > git fetch --tags --force --progress -- https://github.com/EvelioM/CalidadIntegracionContinua +refs/heads/*:refs/remotes/origin/* # timeout=10
 > git rev-parse refs/remotes/origin/master^{commit} # timeout=10
 > git rev-parse refs/remotes/origin/origin/master^{commit} # timeout=10
Checking out Revision 59c0a3b263c77fca675e9b99b73b4670c39180d0 (refs/remotes/origin/master)
 > git config core.sparsecheckout # timeout=10
 > git checkout -f 59c0a3b263c77fca675e9b99b73b4670c39180d0 # timeout=10
Commit message: "Fixed failing Test"
 > git rev-list --no-walk 7fbdee9f5a03850861194fa78bf27506a7f05615 # timeout=10
Parsing POMs
Established TCP socket on 40781
[demo] $ /usr/lib/jvm/java-8-openjdk-amd64/bin/java -cp /var/lib/jenkins/plugins/maven-plugin/WEB-INF/lib/maven35-agent-1.13.jar:/var/lib/jenkins/tools/hudson.tasks.Maven_MavenInstallation/Maven/boot/plexus-classworlds-2.6.0.jar:/var/lib/jenkins/tools/hudson.tasks.Maven_MavenInstallation/Maven/conf/logging jenkins.maven3.agent.Maven35Main /var/lib/jenkins/tools/hudson.tasks.Maven_MavenInstallation/Maven /var/cache/jenkins/war/WEB-INF/lib/remoting-3.36.jar /var/lib/jenkins/plugins/maven-plugin/WEB-INF/lib/maven35-interceptor-1.13.jar /var/lib/jenkins/plugins/maven-plugin/WEB-INF/lib/maven3-interceptor-commons-1.13.jar 40781
<===[JENKINS REMOTING CAPACITY]===>channel started
Executing Maven:  -B -f /var/lib/jenkins/workspace/CIMaven/demo/pom.xml install
[INFO] Scanning for projects...
[INFO] 
[INFO] --------------------------< com.example:demo >--------------------------
[INFO] Building demo 0.0.1-SNAPSHOT
[INFO] --------------------------------[ jar ]---------------------------------
[INFO] 
[INFO] --- maven-resources-plugin:3.1.0:resources (default-resources) @ demo ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] Copying 1 resource
[INFO] Copying 0 resource
[INFO] 
[INFO] --- maven-compiler-plugin:3.8.1:compile (default-compile) @ demo ---
[INFO] Nothing to compile - all classes are up to date
[INFO] 
[INFO] --- maven-resources-plugin:3.1.0:testResources (default-testResources) @ demo ---
[INFO] Using 'UTF-8' encoding to copy filtered resources.
[INFO] skip non existing resourceDirectory /var/lib/jenkins/workspace/CIMaven/demo/src/test/resources
[INFO] 
[INFO] --- maven-compiler-plugin:3.8.1:testCompile (default-testCompile) @ demo ---
[INFO] Changes detected - recompiling the module!
[INFO] Compiling 2 source files to /var/lib/jenkins/workspace/CIMaven/demo/target/test-classes
[INFO] 
[INFO] --- maven-surefire-plugin:2.22.2:test (default-test) @ demo ---
[INFO] 
[INFO] -------------------------------------------------------
[INFO]  T E S T S
[INFO] -------------------------------------------------------
[INFO] Running com.example.demo.rest.dao.EmployeeDaoTest
17:22:01.262 [main] DEBUG org.springframework.test.context.BootstrapUtils - Instantiating CacheAwareContextLoaderDelegate from class [org.springframework.test.context.cache.DefaultCacheAwareContextLoaderDelegate]
17:22:01.282 [main] DEBUG org.springframework.test.context.BootstrapUtils - Instantiating BootstrapContext using constructor [public org.springframework.test.context.support.DefaultBootstrapContext(java.lang.Class,org.springframework.test.context.CacheAwareContextLoaderDelegate)]
17:22:01.329 [main] DEBUG org.springframework.test.context.BootstrapUtils - Instantiating TestContextBootstrapper for test class [com.example.demo.rest.dao.EmployeeDaoTest] from class [org.springframework.boot.test.context.SpringBootTestContextBootstrapper]
17:22:01.357 [main] INFO org.springframework.boot.test.context.SpringBootTestContextBootstrapper - Neither @ContextConfiguration nor @ContextHierarchy found for test class [com.example.demo.rest.dao.EmployeeDaoTest], using SpringBootContextLoader
17:22:01.365 [main] DEBUG org.springframework.test.context.support.AbstractContextLoader - Did not detect default resource location for test class [com.example.demo.rest.dao.EmployeeDaoTest]: class path resource [com/example/demo/rest/dao/EmployeeDaoTest-context.xml] does not exist
17:22:01.365 [main] DEBUG org.springframework.test.context.support.AbstractContextLoader - Did not detect default resource location for test class [com.example.demo.rest.dao.EmployeeDaoTest]: class path resource [com/example/demo/rest/dao/EmployeeDaoTestContext.groovy] does not exist
17:22:01.366 [main] INFO org.springframework.test.context.support.AbstractContextLoader - Could not detect default resource locations for test class [com.example.demo.rest.dao.EmployeeDaoTest]: no resource found for suffixes {-context.xml, Context.groovy}.
17:22:01.367 [main] INFO org.springframework.test.context.support.AnnotationConfigContextLoaderUtils - Could not detect default configuration classes for test class [com.example.demo.rest.dao.EmployeeDaoTest]: EmployeeDaoTest does not declare any static, non-private, non-final, nested classes annotated with @Configuration.
17:22:01.428 [main] DEBUG org.springframework.test.context.support.ActiveProfilesUtils - Could not find an 'annotation declaring class' for annotation type [org.springframework.test.context.ActiveProfiles] and class [com.example.demo.rest.dao.EmployeeDaoTest]
17:22:01.524 [main] DEBUG org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider - Identified candidate component class: file [/var/lib/jenkins/workspace/CIMaven/demo/target/classes/com/example/demo/DemoApplication.class]
17:22:01.526 [main] INFO org.springframework.boot.test.context.SpringBootTestContextBootstrapper - Found @SpringBootConfiguration com.example.demo.DemoApplication for test class com.example.demo.rest.dao.EmployeeDaoTest
17:22:01.673 [main] DEBUG org.springframework.boot.test.context.SpringBootTestContextBootstrapper - @TestExecutionListeners is not present for class [com.example.demo.rest.dao.EmployeeDaoTest]: using defaults.
17:22:01.673 [main] INFO org.springframework.boot.test.context.SpringBootTestContextBootstrapper - Loaded default TestExecutionListener class names from location [META-INF/spring.factories]: [org.springframework.boot.test.mock.mockito.MockitoTestExecutionListener, org.springframework.boot.test.mock.mockito.ResetMocksTestExecutionListener, org.springframework.boot.test.autoconfigure.restdocs.RestDocsTestExecutionListener, org.springframework.boot.test.autoconfigure.web.client.MockRestServiceServerResetTestExecutionListener, org.springframework.boot.test.autoconfigure.web.servlet.MockMvcPrintOnlyOnFailureTestExecutionListener, org.springframework.boot.test.autoconfigure.web.servlet.WebDriverTestExecutionListener, org.springframework.test.context.web.ServletTestExecutionListener, org.springframework.test.context.support.DirtiesContextBeforeModesTestExecutionListener, org.springframework.test.context.support.DependencyInjectionTestExecutionListener, org.springframework.test.context.support.DirtiesContextTestExecutionListener, org.springframework.test.context.transaction.TransactionalTestExecutionListener, org.springframework.test.context.jdbc.SqlScriptsTestExecutionListener, org.springframework.test.context.event.EventPublishingTestExecutionListener]
17:22:01.691 [main] DEBUG org.springframework.boot.test.context.SpringBootTestContextBootstrapper - Skipping candidate TestExecutionListener [org.springframework.test.context.transaction.TransactionalTestExecutionListener] due to a missing dependency. Specify custom listener classes or make the default listener classes and their required dependencies available. Offending class: [org/springframework/transaction/TransactionDefinition]
17:22:01.691 [main] DEBUG org.springframework.boot.test.context.SpringBootTestContextBootstrapper - Skipping candidate TestExecutionListener [org.springframework.test.context.jdbc.SqlScriptsTestExecutionListener] due to a missing dependency. Specify custom listener classes or make the default listener classes and their required dependencies available. Offending class: [org/springframework/transaction/interceptor/TransactionAttribute]
17:22:01.692 [main] INFO org.springframework.boot.test.context.SpringBootTestContextBootstrapper - Using TestExecutionListeners: [org.springframework.test.context.web.ServletTestExecutionListener@2f217633, org.springframework.test.context.support.DirtiesContextBeforeModesTestExecutionListener@a530d0a, org.springframework.boot.test.mock.mockito.MockitoTestExecutionListener@1a18644, org.springframework.boot.test.autoconfigure.SpringBootDependencyInjectionTestExecutionListener@5acf93bb, org.springframework.test.context.support.DirtiesContextTestExecutionListener@7e7be63f, org.springframework.test.context.event.EventPublishingTestExecutionListener@6cd28fa7, org.springframework.boot.test.mock.mockito.ResetMocksTestExecutionListener@614ca7df, org.springframework.boot.test.autoconfigure.restdocs.RestDocsTestExecutionListener@4738a206, org.springframework.boot.test.autoconfigure.web.client.MockRestServiceServerResetTestExecutionListener@66d3eec0, org.springframework.boot.test.autoconfigure.web.servlet.MockMvcPrintOnlyOnFailureTestExecutionListener@1e04fa0a, org.springframework.boot.test.autoconfigure.web.servlet.WebDriverTestExecutionListener@1af2d44a]
17:22:01.697 [main] DEBUG org.springframework.test.context.support.AbstractDirtiesContextTestExecutionListener - Before test class: context [DefaultTestContext@52af26ee testClass = EmployeeDaoTest, testInstance = [null], testMethod = [null], testException = [null], mergedContextConfiguration = [WebMergedContextConfiguration@6fd83fc1 testClass = EmployeeDaoTest, locations = '{}', classes = '{class com.example.demo.DemoApplication}', contextInitializerClasses = '[]', activeProfiles = '{}', propertySourceLocations = '{}', propertySourceProperties = '{org.springframework.boot.test.context.SpringBootTestContextBootstrapper=true}', contextCustomizers = set[org.springframework.boot.test.context.filter.ExcludeFilterContextCustomizer@48aaecc3, org.springframework.boot.test.json.DuplicateJsonObjectContextCustomizerFactory$DuplicateJsonObjectContextCustomizer@5cee5251, org.springframework.boot.test.mock.mockito.MockitoContextCustomizer@0, org.springframework.boot.test.web.client.TestRestTemplateContextCustomizer@78b66d36, org.springframework.boot.test.autoconfigure.properties.PropertyMappingContextCustomizer@0, org.springframework.boot.test.autoconfigure.web.servlet.WebDriverContextCustomizerFactory$Customizer@2e4b8173], resourceBasePath = 'src/main/webapp', contextLoader = 'org.springframework.boot.test.context.SpringBootContextLoader', parent = [null]], attributes = map['org.springframework.test.context.web.ServletTestExecutionListener.activateListener' -> true]], class annotated with @DirtiesContext [false] with mode [null].
17:22:01.740 [main] DEBUG org.springframework.test.context.support.TestPropertySourceUtils - Adding inlined properties to environment: {spring.jmx.enabled=false, org.springframework.boot.test.context.SpringBootTestContextBootstrapper=true, server.port=-1}

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::        (v2.2.2.RELEASE)

2020-01-11 17:22:02.173  INFO 14310 --- [           main] c.example.demo.rest.dao.EmployeeDaoTest  : Starting EmployeeDaoTest on evelio with PID 14310 (started by jenkins in /var/lib/jenkins/workspace/CIMaven/demo)
2020-01-11 17:22:02.177  INFO 14310 --- [           main] c.example.demo.rest.dao.EmployeeDaoTest  : No active profile set, falling back to default profiles: default
2020-01-11 17:22:04.388  INFO 14310 --- [           main] o.s.s.concurrent.ThreadPoolTaskExecutor  : Initializing ExecutorService 'applicationTaskExecutor'
2020-01-11 17:22:04.924  INFO 14310 --- [           main] c.example.demo.rest.dao.EmployeeDaoTest  : Started EmployeeDaoTest in 3.168 seconds (JVM running for 4.548)
[INFO] Tests run: 2, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 4.432 s - in com.example.demo.rest.dao.EmployeeDaoTest
[INFO] Running com.example.demo.DemoApplicationTests
2020-01-11 17:22:05.585  INFO 14310 --- [           main] .b.t.c.SpringBootTestContextBootstrapper : Neither @ContextConfiguration nor @ContextHierarchy found for test class [com.example.demo.DemoApplicationTests], using SpringBootContextLoader
2020-01-11 17:22:05.586  INFO 14310 --- [           main] o.s.t.c.support.AbstractContextLoader    : Could not detect default resource locations for test class [com.example.demo.DemoApplicationTests]: no resource found for suffixes {-context.xml, Context.groovy}.
2020-01-11 17:22:05.587  INFO 14310 --- [           main] t.c.s.AnnotationConfigContextLoaderUtils : Could not detect default configuration classes for test class [com.example.demo.DemoApplicationTests]: DemoApplicationTests does not declare any static, non-private, non-final, nested classes annotated with @Configuration.
2020-01-11 17:22:05.593  INFO 14310 --- [           main] .b.t.c.SpringBootTestContextBootstrapper : Found @SpringBootConfiguration com.example.demo.DemoApplication for test class com.example.demo.DemoApplicationTests
2020-01-11 17:22:05.596  INFO 14310 --- [           main] .b.t.c.SpringBootTestContextBootstrapper : Loaded default TestExecutionListener class names from location [META-INF/spring.factories]: [org.springframework.boot.test.mock.mockito.MockitoTestExecutionListener, org.springframework.boot.test.mock.mockito.ResetMocksTestExecutionListener, org.springframework.boot.test.autoconfigure.restdocs.RestDocsTestExecutionListener, org.springframework.boot.test.autoconfigure.web.client.MockRestServiceServerResetTestExecutionListener, org.springframework.boot.test.autoconfigure.web.servlet.MockMvcPrintOnlyOnFailureTestExecutionListener, org.springframework.boot.test.autoconfigure.web.servlet.WebDriverTestExecutionListener, org.springframework.test.context.web.ServletTestExecutionListener, org.springframework.test.context.support.DirtiesContextBeforeModesTestExecutionListener, org.springframework.test.context.support.DependencyInjectionTestExecutionListener, org.springframework.test.context.support.DirtiesContextTestExecutionListener, org.springframework.test.context.transaction.TransactionalTestExecutionListener, org.springframework.test.context.jdbc.SqlScriptsTestExecutionListener, org.springframework.test.context.event.EventPublishingTestExecutionListener]
2020-01-11 17:22:05.599  INFO 14310 --- [           main] .b.t.c.SpringBootTestContextBootstrapper : Using TestExecutionListeners: [org.springframework.test.context.web.ServletTestExecutionListener@73a19967, org.springframework.test.context.support.DirtiesContextBeforeModesTestExecutionListener@5e746d37, org.springframework.boot.test.mock.mockito.MockitoTestExecutionListener@6e1b9411, org.springframework.boot.test.autoconfigure.SpringBootDependencyInjectionTestExecutionListener@21d1b321, org.springframework.test.context.support.DirtiesContextTestExecutionListener@5ec46cdd, org.springframework.test.context.event.EventPublishingTestExecutionListener@2324bfe7, org.springframework.boot.test.mock.mockito.ResetMocksTestExecutionListener@112d1c8e, org.springframework.boot.test.autoconfigure.restdocs.RestDocsTestExecutionListener@3d49fd31, org.springframework.boot.test.autoconfigure.web.client.MockRestServiceServerResetTestExecutionListener@4016ccc1, org.springframework.boot.test.autoconfigure.web.servlet.MockMvcPrintOnlyOnFailureTestExecutionListener@46cb98a3, org.springframework.boot.test.autoconfigure.web.servlet.WebDriverTestExecutionListener@3ffb3598]
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0, Time elapsed: 0.001 s - in com.example.demo.DemoApplicationTests
2020-01-11 17:22:05.706  INFO 14310 --- [extShutdownHook] o.s.s.concurrent.ThreadPoolTaskExecutor  : Shutting down ExecutorService 'applicationTaskExecutor'
[INFO] 
[INFO] Results:
[INFO] 
[INFO] Tests run: 3, Failures: 0, Errors: 0, Skipped: 0
[INFO] 
[JENKINS] Recording test results
[INFO] 
[INFO] --- maven-jar-plugin:3.1.2:jar (default-jar) @ demo ---
[INFO] Building jar: /var/lib/jenkins/workspace/CIMaven/demo/target/demo-0.0.1-SNAPSHOT.jar
[INFO] 
[INFO] --- spring-boot-maven-plugin:2.2.2.RELEASE:repackage (repackage) @ demo ---
[INFO] Replacing main artifact with repackaged archive
[INFO] 
[INFO] --- maven-install-plugin:2.5.2:install (default-install) @ demo ---
[INFO] Installing /var/lib/jenkins/workspace/CIMaven/demo/target/demo-0.0.1-SNAPSHOT.jar to /var/lib/jenkins/.m2/repository/com/example/demo/0.0.1-SNAPSHOT/demo-0.0.1-SNAPSHOT.jar
[INFO] Installing /var/lib/jenkins/workspace/CIMaven/demo/pom.xml to /var/lib/jenkins/.m2/repository/com/example/demo/0.0.1-SNAPSHOT/demo-0.0.1-SNAPSHOT.pom
[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  16.477 s
[INFO] Finished at: 2020-01-11T17:22:12+01:00
[INFO] ------------------------------------------------------------------------
Waiting for Jenkins to finish collecting data
[JENKINS] Archiving /var/lib/jenkins/workspace/CIMaven/demo/pom.xml to com.example/demo/0.0.1-SNAPSHOT/demo-0.0.1-SNAPSHOT.pom
[JENKINS] Archiving /var/lib/jenkins/workspace/CIMaven/demo/target/demo-0.0.1-SNAPSHOT.jar to com.example/demo/0.0.1-SNAPSHOT/demo-0.0.1-SNAPSHOT.jar
channel stopped
Uploading Maven asset with groupId: com.example artifactId: demo version: 1.0 packaging: jar To repository: CIMaven
Successfully Uploaded Maven Assets
WARNING: No GitHub config available for this job, GitHub Issue Notifier will not run! Error: Could not connect to GitHub repository. Please double-check that you have correctly configured a GitHub API key.
Finished: SUCCESS
```
