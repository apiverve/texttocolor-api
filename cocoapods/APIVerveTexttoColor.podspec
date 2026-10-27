Pod::Spec.new do |s|
  s.name             = 'APIVerveTexttoColor'
  s.version          = '1.2.3'
  s.summary          = 'Text to Color converts natural language color names into hexadecimal color codes.'
  s.description      = <<-'DESC'
Text to Color converts natural language color names into hexadecimal color codes. Send descriptive color phrases to receive matching hex values and channel counts, with paid plans adding RGB, HSL, and CMYK formats.

This iOS/macOS SDK provides a convenient way to access the Text to Color from APIVerve.
Supports both callback-based and async/await patterns.
                       DESC

  s.homepage         = 'https://apiverve.com/marketplace/texttocolor?utm_source=cocoapods&utm_medium=referral&utm_content=homepage'
  s.license          = { :type => 'MIT', :file => 'LICENSE' }
  s.author           = { 'APIVerve' => 'hello@apiverve.com' }
  # The SDK repo holds every language; the pod lives under cocoapods/ with its own tag.
  s.source           = { :git => 'https://github.com/apiverve/texttocolor-api.git', :tag => "cocoapods/v#{s.version}" }

  s.ios.deployment_target = '15.0'
  s.osx.deployment_target = '12.0'

  s.swift_version = '5.0'

  s.source_files = 'cocoapods/Sources/APIVerveTexttoColor/**/*.swift'

  s.frameworks = 'Foundation'

  # APIResponse, APIVerveError and the request plumbing, shared by every APIVerve pod.
  s.dependency 'APIVerveCore', '~> 1.2'
end
