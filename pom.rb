require 'fileutils'
project 'slider', 'https://github.com/ruby-processing/slider' do
  model_version '4.0.0'
  id 'ruby-processing:slider', '0.1.0'
  packaging 'jar'
  description 'slider for processing'
  organization 'ruby-processing', 'https://ruby-processing.github.io'
  { 'monkstone' => 'Martin Prout' }.each do |key, value|
    developer key do
      name value
      roles 'developer'
    end
  end
  license 'MIT', 'http://www.opensource.org/licenses/mit-license.php'
  license 'GPL 3', 'http://www.gnu.org/licenses/gpl-3.0-standalone.html'  
  issue_management 'https://github.com/ruby-processing/slider/issues', 'Github'
  
  source_control(
    url: 'https://github.com/ruby-processing/slider',
    connection: 'scm:git:git://github.com/ruby-processing/slider.git',
    developer_connection: 'scm:git:git@github.com/ruby-processing/slider.git'
    )
  
  properties('source.directory' => 'src',
    'slider.basedir' => '${project.basedir}',
    'polyglot.dump.pom' => 'pom.xml',
    'maven.compiler.source' => '1.8',
    'project.build.sourceEncoding' => 'utf-8',
    'maven.compiler.target' => '1.8',
    'jruby.api' => 'http://jruby.org/apidocs/',
    'processing.api' => 'http://processing.github.io/processing-javadocs/core/',
    'jruby.api' => 'http://jruby.org/apidocs/',
    )
  
  pom('org.jruby:jruby:9.0.5.0')
  jar('org.processing:core:3.0.1')
  
  overrides do
    plugin :resources, '2.6'
    plugin :dependency, '2.10' do
      execute_goals( id: 'default-cli',
        artifactItems: [ { groupId:  'org.processing',
          artifactId:  'core',
          version:  '3.0.1',         
          type:  'jar',
          outputDirectory: '${slider.basedir}/lib'
        }
        ]
      )
    end
      
    plugin( :compiler, '3.3',
      source: '${maven.compiler.source}',
      target: '${maven.compiler.target}'
    )
    plugin( :javadoc, '2.10.3',
      detect_offline_links:  'false',
      links: ['${jruby.api}', '${processing.api}']
    )
    plugin( :jar, '2.6',
      archive: { manifestFile: 'MANIFEST.MF' }
    )
  end

  build do
    default_goal 'package'
    source_directory 'src'
    final_name 'slider'
  end
end
