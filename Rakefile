# encoding: utf-8
# frozen_string_literal: false
require_relative 'lib/slider/version'

def create_manifest
  title = 'Implementation-Title: slider (java extension for ruby-processing)'
  version = format('Implementation-Version: %s', Slider::VERSION)
  File.open('MANIFEST.MF', 'w') do |f|
    f.puts(title)
    f.puts(version)
    f.puts('Class-Path: core.jar')
  end
end

task default: [:init, :compile, :install, :test]

desc 'Create Manifest'
task :init do
  create_manifest
end

desc 'Install'
task :install do
  sh 'mvn dependency:copy'
  sh 'mv target/slider.jar lib'
end

desc 'Gem'
task :gem do
  sh 'gem build slider.gemspec'
end

desc 'Document'
task :javadoc do
  sh 'mvn javadoc:javadoc'
end

desc 'Compile'
task :compile do
  sh 'mvn package'
end

desc 'Test'
task :test do
    puts 'to be implemented'
end

desc 'clean'
task :clean do
  Dir['./**/*.%w{jar gem}'].each do |path|
    puts 'Deleting #{path} ...'
    File.delete(path)
  end
  FileUtils.rm_rf('./target')
end
