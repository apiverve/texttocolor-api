declare module '@apiverve/texttocolor' {
  export interface texttocolorOptions {
    api_key: string;
    secure?: boolean;
  }

  /**
   * Describes fields the current plan does not unlock. Locked fields arrive as null
   * in `data`; `locked_fields` names them, using dot paths for nested fields.
   * Absent when the plan unlocks everything.
   */
  export interface PremiumInfo {
    message: string;
    upgrade_url: string;
    locked_fields: string[];
  }

  export interface texttocolorResponse {
    status: string;
    error: string | null;
    data: TexttoColorData;
    code?: number;
    premium?: PremiumInfo;
  }


  interface TexttoColorData {
      color:    null | string;
      hex:      null | string;
      rgb:      null | string;
      hsl:      null | string;
      cmyk:     null | string;
      ansi16:   number | null;
      channels: Channels;
  }
  
  interface Channels {
      rgbChannels:  number | null;
      cmykChannels: number | null;
      ansiChannels: number | null;
      hexChannels:  number | null;
      hslChannels:  number | null;
  }

  export default class texttocolorWrapper {
    constructor(options: texttocolorOptions);

    execute(callback: (error: any, data: texttocolorResponse | null) => void): Promise<texttocolorResponse>;
    execute(query: Record<string, any>, callback: (error: any, data: texttocolorResponse | null) => void): Promise<texttocolorResponse>;
    execute(query?: Record<string, any>): Promise<texttocolorResponse>;
  }
}
