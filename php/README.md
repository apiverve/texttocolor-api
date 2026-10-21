# Text to Color API - PHP Package

Text to Color converts natural language color names into hexadecimal color codes. Send descriptive color phrases to receive matching hex values and channel counts, with paid plans adding RGB, HSL, and CMYK formats.

## Installation

Install via Composer:

```bash
composer require apiverve/texttocolor
```

## Getting Started

Get your API key at [APIVerve](https://apiverve.com)

### Basic Usage

```php
<?php

require_once 'vendor/autoload.php';

use APIVerve\Texttocolor\Client;

// Initialize the client
$client = new Client('YOUR_API_KEY');

// Make a request
$response = $client->execute(['color' => 'turquoise']);

// Print the response
print_r($response);
```


### Error Handling

```php
use APIVerve\Texttocolor\Client;
use APIVerve\Texttocolor\Exceptions\APIException;
use APIVerve\Texttocolor\Exceptions\ValidationException;

try {
    $response = $client->execute(['color' => 'turquoise']);
    print_r($response['data']);
} catch (ValidationException $e) {
    echo "Validation error: " . implode(', ', $e->getErrors());
} catch (APIException $e) {
    echo "API error: " . $e->getMessage();
    echo "Status code: " . $e->getStatusCode();
}
```

### Debug Mode

```php
// Enable debug logging
$client = new Client(
    apiKey: 'YOUR_API_KEY',
    debug: true
);
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

## Requirements

- PHP 7.4 or higher
- Guzzle HTTP client

## Documentation

For more information, visit the [API Documentation](https://docs.apiverve.com/ref/texttocolor?utm_source=packagist&utm_medium=referral&utm_content=readme).

## Support

- Website: [https://apiverve.com/marketplace/texttocolor?utm_source=php&utm_medium=referral&utm_content=readme](https://apiverve.com/marketplace/texttocolor?utm_source=php&utm_medium=referral&utm_content=readme)
- Email: hello@apiverve.com

## License

This package is available under the [MIT License](LICENSE).
