declare module '@apiverve/texttocolor' {
  export interface texttocolorOptions {
    api_key: string;
    secure?: boolean;
  }

  export interface texttocolorResponse {
    status: string;
    error: string | null;
    data: TexttoColorData;
    code?: number;
  }


  interface TexttoColorData {
      color:    string;
      hex:      string;
      rgb:      string;
      hsl:      string;
      cmyk:     string;
      ansi16:   number;
      channels: Channels;
  }
  
  interface Channels {
      rgbChannels:  number;
      cmykChannels: number;
      ansiChannels: number;
      hexChannels:  number;
      hslChannels:  number;
  }

  export default class texttocolorWrapper {
    constructor(options: texttocolorOptions);

    execute(callback: (error: any, data: texttocolorResponse | null) => void): Promise<texttocolorResponse>;
    execute(query: Record<string, any>, callback: (error: any, data: texttocolorResponse | null) => void): Promise<texttocolorResponse>;
    execute(query?: Record<string, any>): Promise<texttocolorResponse>;
  }
}
