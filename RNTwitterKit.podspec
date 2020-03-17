require "json"

package = JSON.parse(File.read(File.join(__dir__, "package.json")))

Pod::Spec.new do |s|
  s.name         = "RNTwitterKit"
  s.version      = package["version"]
  s.summary      = package["description"]
  s.homepage     = package["homepage"]
  s.license      = package["license"]
  s.authors      = package["author"]

  s.platforms    = { :ios => "9.0" }
  s.source       = { :git => "https://github.com/mango-chutney/react-native-twitter-kit", :tag => "master" }

  s.source_files  = "ios/**/*.{h,m}"
  s.frameworks   = [ "TwitterKit", "TwitterCore" ]
  s.static_framework = true
  s.dependency "React"
  s.dependency "TwitterKit"

end

