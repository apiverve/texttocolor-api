using System;
using System.Collections.Generic;
using System.Text;
using Newtonsoft.Json;

namespace APIVerve.API.TexttoColor
{
    /// <summary>
    /// Query options for the Text to Color API
    /// </summary>
    public class TexttoColorQueryOptions
    {
        /// <summary>
        /// The text to convert the color from
        /// Example: turquoise
        /// </summary>
        [JsonProperty("color")]
        public string Color { get; set; }
    }
}
