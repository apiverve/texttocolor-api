# Text to Color API - Ruby Gem

Text to Color converts natural language color names into hexadecimal color codes. Send descriptive color phrases to receive matching hex values and channel counts, with paid plans adding RGB, HSL, and CMYK formats.

## Installation

Add this line to your application's Gemfile:

```ruby
gem 'apiverve_texttocolor'
```

And then execute:

```bash
$ bundle install
```

Or install it yourself as:

```bash
$ gem install apiverve_texttocolor
```

## Getting Started

Get your API key at [APIVerve](https://apiverve.com)

### Basic Usage

```ruby
require 'apiverve_texttocolor'

# Initialize the client
client = APIVerve::Texttocolor::Client.new(api_key: "YOUR_API_KEY")

# Make a request
response = client.execute({ color: "turquoise" })

# Print the response
puts response
```


### Error Handling

```ruby
begin
  response = client.execute({ color: "turquoise" })
  puts response["data"]
rescue APIVerve::Texttocolor::ValidationError => e
  puts "Validation error: #{e.errors.join(', ')}"
rescue APIVerve::Texttocolor::APIError => e
  puts "API error: #{e.message}"
  puts "Status code: #{e.status_code}"
end
```

### Debug Mode

```ruby
# Enable debug logging
client = APIVerve::Texttocolor::Client.new(
  api_key: "YOUR_API_KEY",
  debug: true
)
```

## Example Response

```json
{
  "status": "ok",
  "error": null,
  "data": {
    "color": "turquoise",
    "hex": "#66c8b8",
    "rgb": "102, 200, 184",
    "hsl": "170, 47, 59",
    "cmyk": "49, 0, 8, 22",
    "ansi16": 96,
    "channels": {
      "rgbChannels": 3,
      "cmykChannels": 4,
      "ansiChannels": 1,
      "hexChannels": 1,
      "hslChannels": 3
    }
  }
}
```

## Documentation

For more information, visit the [API Documentation](https://docs.apiverve.com/ref/texttocolor?utm_source=rubygems&utm_medium=referral&utm_content=readme).

## Support

- Website: [https://apiverve.com/marketplace/texttocolor?utm_source=ruby&utm_medium=referral&utm_content=readme](https://apiverve.com/marketplace/texttocolor?utm_source=ruby&utm_medium=referral&utm_content=readme)
- Email: hello@apiverve.com

## License

This gem is available under the [MIT License](LICENSE).
